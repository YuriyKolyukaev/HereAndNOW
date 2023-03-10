package com.yuriykyus.walry.domain.repository

import com.yuriykyus.walry.domain.models.CityName
import com.yuriykyus.walry.domain.models.CityPhoto

interface CityRepository {

    fun getCityName(): CityName

    fun saveCityName(cityName: CityName): Boolean

    fun getCityPhoto(cityName: CityName): CityPhoto
}