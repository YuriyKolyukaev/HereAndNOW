package com.yuriykyus.hereandnow.presentation

import androidx.appcompat.app.AppCompatActivity
import com.yuriykyus.hereandnow.databinding.ActivityMainBinding
import android.os.Bundle
import com.yuriykyus.hereandnow.data.repository.CityRepositoryImpl
import com.yuriykyus.hereandnow.data.storage.CityStorageImpl
import com.yuriykyus.hereandnow.domain.usecase.GetCityPhoto
import com.yuriykyus.hereandnow.domain.usecase.GetCityName

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val cityStorage by lazy {
        CityStorageImpl(applicationContext)
    }

    private val cityRepository by lazy(LazyThreadSafetyMode.NONE) {
        CityRepositoryImpl(cityStorage)
    }

    private val getCityName by lazy(LazyThreadSafetyMode.NONE) {
        GetCityName(cityRepository = cityRepository)
    }

    private val getCityPhoto by lazy(LazyThreadSafetyMode.NONE) {
        GetCityPhoto(cityRepository = cityRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


    }
}