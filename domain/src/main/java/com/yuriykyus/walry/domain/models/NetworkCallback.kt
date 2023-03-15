package com.yuriykyus.walry.domain.models

interface NetworkCallback {
    fun onResponse(photoUrlList: List<PhotoUrl>)
    fun onError(error: String)
}