package com.yuriykyus.walry.data.repository

import com.yuriykyus.walry.data.storage.models.City
import com.yuriykyus.walry.data.storage.CityStorage
import com.yuriykyus.walry.domain.models.CityName
import com.yuriykyus.walry.domain.models.CityPhoto
import com.yuriykyus.walry.domain.repository.CityRepository

class CityRepositoryImpl(private val cityStorageImpl: CityStorage) : CityRepository {

    override fun getCityName(): CityName {
        val city = cityStorageImpl.getName()
        return mapToDomain(city = city)
    }

    override fun saveCityName(cityName: CityName): Boolean {
        val city = mapToStorage(cityName)
        return cityStorageImpl.saveName(city = city)
    }

    override fun getCityPhoto(cityName: CityName): CityPhoto {
        return cityStorageImpl.getPhoto(cityName = cityName)
    }

    private fun mapToStorage(cityName: CityName): City {
        return City(cityName = cityName.cityName)
    }

    private fun mapToDomain(city: City): CityName {
        return CityName(city.cityName)
    }
}