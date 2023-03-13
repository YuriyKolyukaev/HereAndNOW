package com.yuriykyus.walry.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yuriykyus.walry.core.*
import com.yuriykyus.walry.core.toMutable
import com.yuriykyus.walry.domain.models.PhotoData
import com.yuriykyus.walry.domain.models.CityPhoto
import com.yuriykyus.walry.domain.usecase.GetCityNameUseCase
import com.yuriykyus.walry.domain.usecase.GetCityPhotoUseCase
import com.yuriykyus.walry.presentation.events.LoadCityEvent
import com.yuriykyus.walry.presentation.events.LoadPhotoEvent
import com.yuriykyus.walry.presentation.events.MainEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PhotoViewModel(
    private val getCityNameUseCase: GetCityNameUseCase,
    private val getCityPhotoUseCase: GetCityPhotoUseCase,
) : ViewModel() {

    val listCitiesLiveData: LiveData<ViewState<List<CityPhoto>>> = MutableLiveData()

    fun send(event: MainEvent) {
        when (event) {
            is LoadCityEvent -> getCity()
            is LoadPhotoEvent -> getCityPhotoList(photoData = event.photoData)
        }
    }

    fun getCity() {

    }

    private fun getCityPhotoList(photoData: PhotoData) {
        listCitiesLiveData.toMutable().postProgress()
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val cityName = getCityPhotoUseCase.getPhotos(photoData)
                if (cityName.isEmpty()) {
                    listCitiesLiveData.toMutable().postError()
                } else {
                    listCitiesLiveData.toMutable().postSuccess(cityName)
                }
            } catch (e: Exception) {
                listCitiesLiveData.toMutable().postError(e)
            }
        }
    }

}