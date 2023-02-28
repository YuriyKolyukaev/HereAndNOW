package com.yuriykyus.hereandnow.domain.repository

import com.yuriykyus.hereandnow.domain.models.CityName
import com.yuriykyus.hereandnow.domain.models.CityPhoto

interface CityRepository {

    fun getCityName(): CityName

    fun saveCityName(cityName: CityName): Boolean

    fun getCityPhoto(cityName: CityName): CityPhoto
}