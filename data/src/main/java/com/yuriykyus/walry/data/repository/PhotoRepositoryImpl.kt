package com.yuriykyus.walry.data.repository

import com.yuriykyus.walry.data.network.Network
import com.yuriykyus.walry.domain.models.NetworkCallback
import com.yuriykyus.walry.domain.repository.PhotoRepository

class PhotoRepositoryImpl(private val network: Network) : PhotoRepository {

    override fun loadPhotoList(tag: String, text: String, networkCallback: NetworkCallback) {
        network.getPhotoList(tag, text, networkCallback)
    }
}