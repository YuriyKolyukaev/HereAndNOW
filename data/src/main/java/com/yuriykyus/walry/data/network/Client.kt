package com.yuriykyus.walry.data.network

import com.yuriykyus.walry.data.network.api.PhotoApi
import com.yuriykyus.walry.data.network.api.PhotoListApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Client {

    init {
        createInterceptor()
        createPhotoListApi()
    }

    private lateinit var photoListApi: PhotoListApi
    private lateinit var photoApi: PhotoApi
    private lateinit var interceptorClient: OkHttpClient

    fun getPhotoListApi() = photoListApi

    private fun createInterceptor() {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        interceptorClient = OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

    private fun createPhotoListApi() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.flickr.com")
            .client(interceptorClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        photoListApi = retrofit.create(PhotoListApi::class.java)
    }

    private fun createPhotoApi() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://live.staticflickr.com/")
            .client(interceptorClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        photoApi = retrofit.create(PhotoApi::class.java)
    }

}