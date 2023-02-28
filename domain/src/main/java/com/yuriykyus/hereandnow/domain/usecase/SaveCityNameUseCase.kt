package com.yuriykyus.hereandnow.domain.usecase

import com.yuriykyus.hereandnow.domain.models.CityName
import com.yuriykyus.hereandnow.domain.repository.CityRepository

class SaveCityNameUseCase(private val cityRepository: CityRepository) {
    fun execute(cityName: CityName): Boolean {
        return cityRepository.saveCityName(cityName = cityName)
    }
}