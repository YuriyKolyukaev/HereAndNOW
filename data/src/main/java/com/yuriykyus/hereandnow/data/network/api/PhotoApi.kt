package com.yuriykyus.hereandnow.data.network.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PhotoApi {

    @GET("/{serverId}/{identifier}_{secret}_b.jpg")
    fun getPhoto(
        @Path("serverId")
        serverId: Int,
        @Path("identifier")
        identifier: String,
        @Path("secret")
        secret: String
    ): Call<Byte>

}