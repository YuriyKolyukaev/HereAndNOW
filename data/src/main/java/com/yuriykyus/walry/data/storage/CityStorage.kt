package com.yuriykyus.walry.data.storage

import com.yuriykyus.walry.data.storage.models.City
import com.yuriykyus.walry.domain.models.CityName
import com.yuriykyus.walry.domain.models.CityPhoto

interface CityStorage {
    fun getName(): City

    fun saveName(city: City): Boolean

    fun getPhoto(cityName: CityName): CityPhoto
}