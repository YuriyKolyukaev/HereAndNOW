package com.yuriykyus.walry.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yuriykyus.walry.data.network.NetworkConstants
import com.yuriykyus.walry.domain.models.CityName
import com.yuriykyus.walry.domain.models.CityPhoto
import com.yuriykyus.walry.domain.models.NetworkCallback
import com.yuriykyus.walry.domain.usecase.GetCityNameUseCase
import com.yuriykyus.walry.domain.usecase.GetCityPhotoUseCase
import com.yuriykyus.walry.presentation.events.LoadCityEvent
import com.yuriykyus.walry.presentation.events.LoadPhotoEvent
import com.yuriykyus.walry.presentation.events.MainEvent
import com.yuriykyus.walry.presentation.states.CityState
import com.yuriykyus.walry.presentation.states.MainState
import com.yuriykyus.walry.presentation.states.PhotoState

class MainViewModel(
    private val getCityNameUseCase: GetCityNameUseCase,
    private val getCityPhotoUseCase: GetCityPhotoUseCase,
) : ViewModel() {

    private val stateMutable = MutableLiveData<MainState>()
    val state: LiveData<MainState> = stateMutable

    init {
        stateMutable.value = CityState(cityName = CityName(""))
    }

    fun send(event: MainEvent) {

        when (event) {
            is LoadCityEvent -> getCity()
            is LoadPhotoEvent -> getCityPhotoList(cityName = event.cityName)
        }
    }

    private fun getCity() {
        val cityName = getCityNameUseCase.execute()
        stateMutable.value = CityState(cityName = cityName)
    }

    private fun getCityPhotoList(cityName: CityName) {

        val networkCallback = object : NetworkCallback {
            override fun onResponse(cityPhotoList: List<CityPhoto>) {
                stateMutable.value = PhotoState(cityPhotoList)
            }

            override fun onError(error: String) {

            }
        }

        getCityPhotoUseCase.execute(NetworkConstants.TAG, cityName, networkCallback)
    }
}