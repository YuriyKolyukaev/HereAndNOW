package com.yuriykyus.walry.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yuriykyus.walry.domain.usecase.GetCityNameUseCase
import com.yuriykyus.walry.domain.usecase.GetPhotosUseCase

class PhotoViewModelFactory(
    val getCityNameUseCase: GetCityNameUseCase,
    val getPhotosUseCase: GetPhotosUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PhotoViewModel(
            getCityNameUseCase = getCityNameUseCase,
            getPhotosUseCase = getPhotosUseCase
        ) as T
    }

}