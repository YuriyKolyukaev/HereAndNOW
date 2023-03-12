package com.yuriykyus.walry.presentation.events

import com.yuriykyus.walry.domain.models.PhotoData

sealed interface MainEvent

object LoadCityEvent : MainEvent

class LoadPhotoEvent(val photoData: PhotoData) : MainEvent {

}