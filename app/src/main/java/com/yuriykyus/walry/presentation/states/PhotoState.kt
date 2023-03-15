package com.yuriykyus.walry.presentation.states

import com.yuriykyus.walry.domain.models.PhotoUrl

data class PhotoState(val photosUrl: List<PhotoUrl>) : MainState {
}