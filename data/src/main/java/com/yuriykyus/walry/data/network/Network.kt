package com.yuriykyus.walry.data.network

import com.yuriykyus.walry.data.network.response.PhotosData

interface Network {
    suspend fun getPhotoList(type: Int = 7, tag: String, text: String): PhotosData?
}