package com.yuriykyus.walry.domain.usecase

import com.yuriykyus.walry.domain.models.PhotoData
import com.yuriykyus.walry.domain.repository.CityRepository

class GetCityNameUseCase(private val cityRepository: CityRepository) {
    fun getCityData(): PhotoData {
        return cityRepository.getCityName()
    }
}