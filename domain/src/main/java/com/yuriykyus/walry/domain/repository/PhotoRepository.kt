package com.yuriykyus.walry.domain.repository

import com.yuriykyus.walry.domain.models.CityPhoto

interface PhotoRepository {
    suspend fun getPhotoList(tag: String, text: String): List<CityPhoto>
}