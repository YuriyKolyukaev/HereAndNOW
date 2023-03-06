package com.yuriykyus.hereandnow.domain.repository

import com.yuriykyus.hereandnow.domain.models.NetworkCallback

interface PhotoRepository {

    fun loadPhotoList(tag: String, text: String, networkCallback: NetworkCallback)

}