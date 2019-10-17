package com.example.flickrdemo.features.photos.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class CategoriesResponseModel(
    @SerializedName("photo") val photosList: List<Photo>,
    @PrimaryKey @SerializedName("page") var pageNumber: Int,
    @SerializedName("pages") var totalNumberOfPagers: Int
)