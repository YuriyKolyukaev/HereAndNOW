package com.yuriykyus.walry.presentation.events

import com.yuriykyus.walry.domain.models.CityName

sealed interface MainEvent

object LoadCityEvent : MainEvent

class LoadPhotoEvent(val cityName: CityName) : MainEvent {

}