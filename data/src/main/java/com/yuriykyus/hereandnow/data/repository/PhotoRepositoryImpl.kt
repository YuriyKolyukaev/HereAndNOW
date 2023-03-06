package com.yuriykyus.hereandnow.data.repository

import com.yuriykyus.hereandnow.data.network.Network
import com.yuriykyus.hereandnow.domain.models.NetworkCallback
import com.yuriykyus.hereandnow.domain.repository.PhotoRepository

class PhotoRepositoryImpl(private val network: Network) : PhotoRepository {

    override fun loadPhotoList(tag: String, text: String, networkCallback: NetworkCallback) {
        network.getPhotoList(tag, text, networkCallback)
    }
}