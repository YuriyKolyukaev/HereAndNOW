package com.yuriykyus.walry.domain.usecase

import com.yuriykyus.walry.domain.models.CityName
import com.yuriykyus.walry.domain.repository.CityRepository

class GetCityNameUseCase(private val cityRepository: CityRepository) {
    fun execute(): CityName {
        return cityRepository.getCityName()
    }
}