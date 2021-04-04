package com.example.android_practice_test.data.remote.model


import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ImageResponse(
    val hits: List<Image>,
    val total: Int,
    val totalHits: Int
)