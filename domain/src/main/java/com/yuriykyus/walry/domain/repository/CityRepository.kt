package com.yuriykyus.walry.domain.repository

import com.yuriykyus.walry.domain.models.PhotoData
import com.yuriykyus.walry.domain.models.PhotoUrl

interface CityRepository {

    fun getCityName(): PhotoData

    fun saveCityName(photoData: PhotoData): Boolean

}