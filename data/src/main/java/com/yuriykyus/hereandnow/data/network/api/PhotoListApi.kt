package com.yuriykyus.hereandnow.data.network.api

import com.yuriykyus.hereandnow.data.network.response.PhotosData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PhotoListApi {
    @GET("/services/rest/")
    fun getPhotoList(
        @Query("method") method: String,
        @Query("api_key") key: String,
        @Query("tags") tags: String,
        @Query("text") text: String,
        @Query("format") format: String,
        @Query("nojsoncallback") callBack: String
    ): Call<PhotosData>
}