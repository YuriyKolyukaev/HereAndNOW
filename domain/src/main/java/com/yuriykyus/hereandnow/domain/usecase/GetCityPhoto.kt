package com.yuriykyus.hereandnow.domain.usecase

import com.yuriykyus.hereandnow.domain.models.CityPhoto
import com.yuriykyus.hereandnow.domain.models.CityName
import com.yuriykyus.hereandnow.domain.repository.CityRepository

class GetCityPhoto(private val cityRepository: CityRepository) {
    fun execute(param: CityName): CityPhoto {
        return cityRepository.getCityPhoto(param)
    }
}