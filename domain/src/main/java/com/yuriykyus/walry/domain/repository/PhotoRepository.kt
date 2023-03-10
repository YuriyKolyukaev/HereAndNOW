package com.yuriykyus.walry.domain.repository

import com.yuriykyus.walry.domain.models.NetworkCallback

interface PhotoRepository {

    fun loadPhotoList(tag: String, text: String, networkCallback: NetworkCallback)

}