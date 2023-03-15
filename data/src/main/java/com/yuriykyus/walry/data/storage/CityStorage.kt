package com.yuriykyus.walry.data.storage

import com.yuriykyus.walry.data.storage.models.City
import com.yuriykyus.walry.domain.models.PhotoData
import com.yuriykyus.walry.domain.models.PhotoUrl

interface CityStorage {
    fun getName(): City

    fun saveName(city: City): Boolean
}