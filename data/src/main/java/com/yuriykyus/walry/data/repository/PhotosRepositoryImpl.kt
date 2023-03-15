package com.yuriykyus.walry.data.repository

import com.yuriykyus.walry.data.network.Network
import com.yuriykyus.walry.data.network.NetworkConstants
import com.yuriykyus.walry.data.network.response.PhotosData
import com.yuriykyus.walry.domain.models.PhotoUrl
import com.yuriykyus.walry.domain.repository.PhotoRepository

class PhotosRepositoryImpl(private val network: Network) : PhotoRepository {

    override suspend fun getPhotoList(tag: String, text: String): List<PhotoUrl> {

        val photoList: List<PhotosData.Photos.Photo>? = network.getPhotoList(NetworkConstants.API_CONTENT_TYPE_DEFAULT, tag, text)?.photos?.photo
        var photoUrlList = mutableListOf<PhotoUrl>()

        if (photoList != null && photoList.isNotEmpty()) {
            photoUrlList = getPhotoUrlList(photoList)
        }

        return photoUrlList
    }

    override suspend fun getSearchPhotos(contentType: Int, tag: String, text: String): List<PhotoUrl> {

        val photoList: List<PhotosData.Photos.Photo>? = network.getPhotoList(contentType, tag, text)?.photos?.photo
        var photoUrlList = mutableListOf<PhotoUrl>()

        if (photoList != null && photoList.isNotEmpty()) {
            photoUrlList = getPhotoUrlList(photoList)
        }

        return photoUrlList
    }

    private fun getPhotoUrlList(photoList: List<PhotosData.Photos.Photo>): MutableList<PhotoUrl> {
        val photoUrlList = mutableListOf<PhotoUrl>()
        var photoUrl: String
        for (n in photoList.indices) {

            val item = photoList[n]
            val server = item.server
            val id = item.id
            val secret = item.secret

            photoUrl = "${NetworkConstants.PHOTO_BASE_URL}${server}/${id}_${secret}_${NetworkConstants.SIZE_SUFFIX_B}"
            photoUrlList.add(n, PhotoUrl(photoUrl))
        }
        return photoUrlList
    }


}