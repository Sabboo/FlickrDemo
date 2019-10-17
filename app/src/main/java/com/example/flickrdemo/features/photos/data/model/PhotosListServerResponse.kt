package com.example.flickrdemo.features.photos.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity
data class PhotosListServerResponse(
    @SerializedName("photos") val photosListResponseModel: PhotosListResponseModel,
    @PrimaryKey @Expose(deserialize = false) var pageNumber: Int
)