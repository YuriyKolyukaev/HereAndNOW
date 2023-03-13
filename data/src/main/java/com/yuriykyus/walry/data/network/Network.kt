package com.yuriykyus.walry.data.network
import com.yuriykyus.walry.data.network.response.PhotosData
import com.yuriykyus.walry.domain.models.NetworkCallback
import com.yuriykyus.walry.domain.models.PhotoData

interface Network {
    suspend fun getPhotoList(tag: String, text: String): PhotosData?

}