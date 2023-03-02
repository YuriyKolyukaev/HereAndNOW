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

    private val stateMutable = MutableLiveData<MainState>()
    val state: LiveData<MainState> = stateMutable

    init {
        stateMutable.value = MainState(cityName = "", cityPhoto = "")
    }

    fun send(event: MainEvent) {

        when (event) {
            is LoadCityEvent -> {
                getCity()
            }

            is LoadPhotoEvent -> {

            }
        }
    }

    private fun getCity() {
        val cityName = getCityNameUseCase.execute().cityName
        stateMutable.value = MainState(cityName = cityName, cityPhoto = state.value!!.cityPhoto)
    }

    override fun onCleared() {
        super.onCleared()
    }
}