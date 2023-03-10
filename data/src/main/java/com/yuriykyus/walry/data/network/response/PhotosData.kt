package com.yuriykyus.walry.data.network.response

import com.google.gson.annotations.SerializedName

data class PhotosData(
    @SerializedName("photos")
    val photos: Photos
) {
    data class Photos(
        @SerializedName("photo")
        val photo: List<Photo>
    ) {
        data class Photo(
            val server: String,
            val secret: String,
            val id: String
        )
    }
}