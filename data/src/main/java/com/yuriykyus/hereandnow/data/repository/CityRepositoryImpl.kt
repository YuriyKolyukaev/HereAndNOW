package com.yuriykyus.hereandnow.data.repository

import com.yuriykyus.hereandnow.data.storage.City
import com.yuriykyus.hereandnow.data.storage.CityStorage
import com.yuriykyus.hereandnow.domain.models.CityName
import com.yuriykyus.hereandnow.domain.models.CityPhoto
import com.yuriykyus.hereandnow.domain.repository.CityRepository

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