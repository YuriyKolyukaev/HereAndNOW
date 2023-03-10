package com.yuriykyus.walry.presentation

import androidx.appcompat.app.AppCompatActivity
import com.yuriykyus.walry.databinding.ActivityMainBinding
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.yuriykyus.walry.domain.models.CityName
import com.yuriykyus.walry.presentation.events.LoadCityEvent
import com.yuriykyus.walry.presentation.events.LoadPhotoEvent
import com.yuriykyus.walry.presentation.states.PhotoState

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
            rvPhoto.layoutManager = GridLayoutManager(this@MainActivity, 2)
            rvPhoto.adapter = adapter
            rvPhoto.setHasFixedSize(true)
        }
    }

}