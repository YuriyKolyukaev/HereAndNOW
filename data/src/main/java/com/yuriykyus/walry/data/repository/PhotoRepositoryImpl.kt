package com.yuriykyus.walry.data.repository

import com.yuriykyus.walry.data.network.Network
import com.yuriykyus.walry.data.network.NetworkConstants
import com.yuriykyus.walry.data.network.response.PhotosData
import com.yuriykyus.walry.domain.models.CityPhoto
import com.yuriykyus.walry.domain.repository.PhotoRepository

class PhotoRepositoryImpl(private val network: Network) : PhotoRepository {

    override suspend fun getPhotoList(tag: String, text: String): List<CityPhoto> {

        val photoList: List<PhotosData.Photos.Photo>? = network.getPhotoList(tag, text)?.photos?.photo
        val photoUrlList = mutableListOf<CityPhoto>()
        var photoUrl: String

        if (photoList != null && photoList.isNotEmpty()) {
            for (n in photoList.indices) {

                val item = photoList[n]
                val server = item.server
                val id = item.id
                val secret = item.secret

                photoUrl = "${NetworkConstants.PHOTO_BASE_URL}${server}/${id}_${secret}_${NetworkConstants.SIZE_SUFFIX_B}"
                photoUrlList.add(n, CityPhoto(photoUrl))
            }
        }
        return photoUrlList
    }
}