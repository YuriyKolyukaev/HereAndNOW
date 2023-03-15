package com.yuriykyus.walry.domain.usecase

import com.yuriykyus.walry.domain.models.PhotoUrl
import com.yuriykyus.walry.domain.models.PhotoData
import com.yuriykyus.walry.domain.models.SearchData
import com.yuriykyus.walry.domain.repository.PhotoRepository

class GetPhotosUseCase(private val photoRepository: PhotoRepository) {
    suspend fun getPhotos(param: PhotoData): List<PhotoUrl> {
        return photoRepository.getPhotoList(param.tag, param.text)
    }

    suspend fun getSearchPhotos(param: SearchData): List<PhotoUrl> {
        return photoRepository.getSearchPhotos(param.contentType, param.tag, param.text)
    }
}