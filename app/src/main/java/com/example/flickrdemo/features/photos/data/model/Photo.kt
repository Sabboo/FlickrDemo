package com.example.flickrdemo.features.photos.data.model

import com.google.gson.annotations.SerializedName

data class Photo(
    @SerializedName("id") val id: String,
    @SerializedName("secret") val secret: String,
    @SerializedName("server") val server: String,
    @SerializedName("farm") val farm: String
)