package com.example.android_practice_test.data.remote

import com.example.android_practice_test.BuildConfig
import com.example.android_practice_test.data.remote.model.ImageResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ImageService {

    @GET("api")
    suspend fun fetchImage(
        @Query("q") searchQuery: String,
        @Query("key") apiKey: String = BuildConfig.API_KEY
    ) : Response<ImageResponse>

}