package com.yuriykyus.walry.data.repository

import com.yuriykyus.walry.data.storage.models.City
import com.yuriykyus.walry.data.storage.CityStorage
import com.yuriykyus.walry.domain.models.PhotoData
import com.yuriykyus.walry.domain.models.CityPhoto
import com.yuriykyus.walry.domain.repository.CityRepository

class CityRepositoryImpl(private val cityStorageImpl: CityStorage) : CityRepository {

    override fun getCityName(): PhotoData {
        val city = cityStorageImpl.getName()
        return mapToDomain(city = city)
    }

    override fun saveCityName(photoData: PhotoData): Boolean {
        val city = mapToStorage(photoData)
        return cityStorageImpl.saveName(city = city)
    }

    override fun getCityPhoto(photoData: PhotoData): CityPhoto {
        return cityStorageImpl.getPhoto(photoData = photoData)
    }

    private fun mapToStorage(photoData: PhotoData): City {
        return City(cityName = photoData.photoText)
    }

    private fun mapToDomain(city: City): PhotoData {
        return PhotoData("", city.cityName)
    }
}