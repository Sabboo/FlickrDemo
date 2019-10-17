package com.example.flickrdemo.features.photos.data.model

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class PhotosListResponseModel(
    @SerializedName("photo") val photosList: List<Photo>,
    @PrimaryKey @SerializedName("page") var pageNumber: Int,
    @SerializedName("pages") var totalNumberOfPages: Int
)