package com.yuriykyus.walry.domain.usecase

import com.yuriykyus.walry.domain.models.CityName
import com.yuriykyus.walry.domain.models.NetworkCallback
import com.yuriykyus.walry.domain.repository.PhotoRepository

class GetCityPhotoUseCase(private val photoRepository: PhotoRepository) {
    fun execute(tag: String, param: CityName, networkCallback: NetworkCallback) {
        photoRepository.loadPhotoList(tag, param.cityName, networkCallback)
    }
}