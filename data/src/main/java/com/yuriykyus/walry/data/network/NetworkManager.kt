package com.yuriykyus.walry.data.network

import com.yuriykyus.walry.data.network.response.PhotosData

class NetworkManager : Network {

    private val client = Client()

    override suspend fun getPhotoList(type: Int, tag: String, text: String): PhotosData? {

        return client.getPhotoListApi().getPhotoList(
            method = NetworkConstants.API_METHOD_NAME,
            NetworkConstants.KEY,
            tag,
            text,
            type = type,
            format = NetworkConstants.API_RESPONSE_FORMAT,
            callBack = NetworkConstants.API_CALLBACK_NUMBER
        )
    }

}