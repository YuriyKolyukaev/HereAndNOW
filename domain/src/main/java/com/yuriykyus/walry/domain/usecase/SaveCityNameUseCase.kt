package com.yuriykyus.walry.domain.usecase

import com.yuriykyus.walry.domain.models.CityName
import com.yuriykyus.walry.domain.repository.CityRepository

class SaveCityNameUseCase(private val cityRepository: CityRepository) {
    fun execute(cityName: CityName): Boolean {
        return cityRepository.saveCityName(cityName = cityName)
    }
}