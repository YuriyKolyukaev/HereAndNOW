package com.yuriykyus.hereandnow.presentation.states

import com.yuriykyus.hereandnow.domain.models.CityName

data class CityState(val cityName: CityName) : MainState {
}