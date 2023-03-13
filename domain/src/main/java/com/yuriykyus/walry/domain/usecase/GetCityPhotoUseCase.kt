package com.yuriykyus.walry.domain.usecase

import com.yuriykyus.walry.domain.models.CityPhoto
import com.yuriykyus.walry.domain.models.PhotoData
import com.yuriykyus.walry.domain.models.NetworkCallback
import com.yuriykyus.walry.domain.repository.PhotoRepository

class GetCityPhotoUseCase(private val photoRepository: PhotoRepository) {
    suspend fun getPhotos(param: PhotoData): List<CityPhoto> {
        return photoRepository.getPhotoList(param.tag, param.photoText)
    }
}