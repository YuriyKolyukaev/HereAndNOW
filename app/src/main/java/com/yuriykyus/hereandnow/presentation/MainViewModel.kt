package com.yuriykyus.hereandnow.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yuriykyus.hereandnow.domain.usecase.GetCityNameUseCase
import com.yuriykyus.hereandnow.domain.usecase.GetCityPhotoUseCase

class MainViewModel(
    private val getCityNameUseCase: GetCityNameUseCase,
    private val getCityPhotoUseCase: GetCityPhotoUseCase,
) : ViewModel() {

    private val mutableLiveData = MutableLiveData<String>()
    val liveData: LiveData<String> = mutableLiveData

    fun getCity(): String {
        return getCityNameUseCase.execute().cityName
    }

    override fun onCleared() {
        super.onCleared()
    }
}