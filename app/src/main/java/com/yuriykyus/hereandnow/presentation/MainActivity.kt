package com.yuriykyus.hereandnow.presentation

import androidx.appcompat.app.AppCompatActivity
import com.yuriykyus.hereandnow.databinding.ActivityMainBinding
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.yuriykyus.hereandnow.domain.models.CityName
import com.yuriykyus.hereandnow.presentation.events.LoadCityEvent
import com.yuriykyus.hereandnow.presentation.events.LoadPhotoEvent
import com.yuriykyus.hereandnow.presentation.states.PhotoState

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: PhotoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initAdapter()

        viewModel = ViewModelProvider(this, MainViewModelFactory(this))
            .get(MainViewModel::class.java)

        viewModel.state.observe(this) { state ->
            when (state) {
                is PhotoState -> adapter.addPhotoUrlList(state.photosUrl)
            }
        }

        viewModel.send(LoadCityEvent)
        viewModel.send(LoadPhotoEvent(cityName = CityName("Moscow")))
    }

    private fun initAdapter() {

        binding.apply {
            adapter = PhotoAdapter()
            rvPhoto.layoutManager = GridLayoutManager(this@MainActivity, 3)
            rvPhoto.adapter = adapter
            rvPhoto.setHasFixedSize(true)
        }
    }

}