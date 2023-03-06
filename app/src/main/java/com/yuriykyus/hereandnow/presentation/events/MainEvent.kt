package com.yuriykyus.hereandnow.presentation.events

import com.yuriykyus.hereandnow.domain.models.CityName

sealed interface MainEvent

object LoadCityEvent : MainEvent

class LoadPhotoEvent(val cityName: CityName) : MainEvent {

}