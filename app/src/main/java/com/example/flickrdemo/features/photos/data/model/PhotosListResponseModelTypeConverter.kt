package com.example.flickrdemo.features.photos.data.model

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PhotosListResponseModelTypeConverter {

    private val gson = Gson()
    private val type = object : TypeToken<PhotosListResponseModel>() {}.type

    @TypeConverter
    fun fromPhotosListToString(photosList: PhotosListResponseModel?): String? {
        return if (photosList == null) null else gson.toJson(photosList, type)
    }

    @TypeConverter
    fun fromStringToPhotosList(json: String?): PhotosListResponseModel? {
        return json?.let { gson.fromJson(json, type) }
    }

}