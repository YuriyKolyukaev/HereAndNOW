package com.yuriykyus.walry.presentation.states

import com.yuriykyus.walry.domain.models.CityPhoto

data class PhotoState(val photosUrl: List<CityPhoto>) : MainState {
}