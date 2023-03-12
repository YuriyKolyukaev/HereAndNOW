package com.yuriykyus.walry.domain.usecase

import com.yuriykyus.walry.domain.models.PhotoData
import com.yuriykyus.walry.domain.models.NetworkCallback
import com.yuriykyus.walry.domain.repository.PhotoRepository

class GetCityPhotoUseCase(private val photoRepository: PhotoRepository) {
    fun execute(param: PhotoData, networkCallback: NetworkCallback) {
        photoRepository.loadPhotoList(param.tag, param.photoText, networkCallback)
    }
}