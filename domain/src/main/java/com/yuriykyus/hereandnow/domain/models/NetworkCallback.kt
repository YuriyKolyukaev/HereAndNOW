package com.yuriykyus.hereandnow.domain.models

interface NetworkCallback {
    fun onResponse(cityPhotoList: List<CityPhoto>)
    fun onError(error: String)
}