package com.yuriykyus.walry.domain.repository

import com.yuriykyus.walry.domain.models.PhotoUrl

interface PhotoRepository {
    suspend fun getPhotoList(tag: String, text: String): List<PhotoUrl>

    suspend fun getSearchPhotos(contentType: Int, tag: String, text: String): List<PhotoUrl>
}