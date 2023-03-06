package com.yuriykyus.hereandnow.data.network
import com.yuriykyus.hereandnow.domain.models.NetworkCallback

interface Network {
    fun getPhotoList(tag: String, text: String, networkCallback: NetworkCallback)
}