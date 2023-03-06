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

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel by lazy {
        ViewModelProvider(this, MainViewModelFactory(this))[MainViewModel::class.java]
    }

    private lateinit var adapter: PhotoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initAdapter()

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