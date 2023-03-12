package com.yuriykyus.walry.domain.usecase

import com.yuriykyus.walry.domain.models.PhotoData
import com.yuriykyus.walry.domain.repository.CityRepository

class SaveCityNameUseCase(private val cityRepository: CityRepository) {
    fun execute(photoData: PhotoData): Boolean {
        return cityRepository.saveCityName(photoData = photoData)
    }
}