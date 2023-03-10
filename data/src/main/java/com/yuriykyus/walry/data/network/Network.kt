package com.yuriykyus.walry.data.network
import com.yuriykyus.walry.domain.models.NetworkCallback

interface Network {
    fun getPhotoList(tag: String, text: String, networkCallback: NetworkCallback)
}