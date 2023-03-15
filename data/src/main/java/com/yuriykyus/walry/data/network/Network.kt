package com.yuriykyus.walry.data.network

import com.yuriykyus.walry.data.network.response.PhotosData
import com.yuriykyus.walry.domain.models.PhotoData

interface Network {
    suspend fun getPhotoList(type: Int = 7, tag: String, text: String): PhotosData?
}