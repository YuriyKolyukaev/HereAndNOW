package com.yuriykyus.walry.domain.models

interface NetworkCallback {
    fun onResponse(cityPhotoList: List<CityPhoto>)
    fun onError(error: String)
}