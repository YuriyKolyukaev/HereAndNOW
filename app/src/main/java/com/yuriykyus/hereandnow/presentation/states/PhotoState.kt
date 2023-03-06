package com.yuriykyus.hereandnow.presentation.states

import com.yuriykyus.hereandnow.domain.models.CityPhoto

data class PhotoState(val photosUrl: List<CityPhoto>) : MainState {
}