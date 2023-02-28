package com.yuriykyus.hereandnow.data.storage

import com.yuriykyus.hereandnow.domain.models.CityName
import com.yuriykyus.hereandnow.domain.models.CityPhoto

interface CityStorage {
    fun getName(): City

    fun saveName(city: City): Boolean

    fun getPhoto(cityName: CityName): CityPhoto
}