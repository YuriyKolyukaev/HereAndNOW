package com.yuriykyus.hereandnow.data.network

import com.yuriykyus.hereandnow.data.network.NetworkConstants.Companion.PHOTO_BASE_URL
import com.yuriykyus.hereandnow.data.network.NetworkConstants.Companion.SIZE_SUFFIX_B
import com.yuriykyus.hereandnow.data.network.response.PhotosData
import com.yuriykyus.hereandnow.domain.models.CityPhoto
import com.yuriykyus.hereandnow.domain.models.NetworkCallback
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NetworkManager : Network {

    private val client = Client()

    override fun getPhotoList(tag: String, text: String, networkCallback: NetworkCallback) {
        val photoListApi = client.getPhotoListApi()

        photoListApi.getPhotoList(
            method = "flickr.photos.search",
            NetworkConstants.KEY,
            tag,
            text,
            format = "json",
            callBack = "1"
        )
            .enqueue(object :
                Callback<PhotosData> {
                override fun onResponse(call: Call<PhotosData>, response: Response<PhotosData>) {
                    if (response.isSuccessful && response.body() != null) {

                        val photoList: List<PhotosData.Photos.Photo>? =
                            response.body()?.photos?.photo
                        val photoUrlList = mutableListOf<CityPhoto>()
                        var photoUrl: String

                        if (photoList != null && photoList.isNotEmpty()) {
                            for (n in photoList.indices) {

                                val item = photoList[n]
                                val server = item.server
                                val id = item.id
                                val secret = item.secret

                                photoUrl =
                                    "$PHOTO_BASE_URL${server}/${id}_${secret}_$SIZE_SUFFIX_B"
                                photoUrlList.add(n, CityPhoto(photoUrl))
                            }

                            networkCallback.onResponse(photoUrlList)
                        }

                    } else {
                        networkCallback.onError(response.errorBody().toString())
                    }
                }

                override fun onFailure(call: Call<PhotosData>, t: Throwable) {
                    networkCallback.onError(t.message.toString())
                }
            })
    }

}