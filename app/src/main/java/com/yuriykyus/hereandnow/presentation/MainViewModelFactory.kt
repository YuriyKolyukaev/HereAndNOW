package com.yuriykyus.hereandnow.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yuriykyus.hereandnow.data.repository.CityRepositoryImpl
import com.yuriykyus.hereandnow.data.storage.CityStorageImpl
import com.yuriykyus.hereandnow.domain.usecase.GetCityNameUseCase
import com.yuriykyus.hereandnow.domain.usecase.GetCityPhotoUseCase

class MainViewModelFactory(context: Context) : ViewModelProvider.Factory {

    private val cityRepository by lazy(LazyThreadSafetyMode.NONE) {
        CityRepositoryImpl(cityStorageImpl = CityStorageImpl(context = context))
    }

    private val getCityNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetCityNameUseCase(cityRepository = cityRepository)
    }

    private val getCityPhotoUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetCityPhotoUseCase(cityRepository = cityRepository)
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            getCityNameUseCase = getCityNameUseCase,
            getCityPhotoUseCase = getCityPhotoUseCase
        ) as T
    }

}