package com.yuriykyus.hereandnow.domain.usecase

import com.yuriykyus.hereandnow.domain.models.CityName
import com.yuriykyus.hereandnow.domain.models.NetworkCallback
import com.yuriykyus.hereandnow.domain.repository.PhotoRepository

class GetCityPhotoUseCase(private val photoRepository: PhotoRepository) {
    fun execute(tag: String, param: CityName, networkCallback: NetworkCallback) {
        photoRepository.loadPhotoList(tag, param.cityName, networkCallback)
    }
}