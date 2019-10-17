package com.example.flickrdemo.features.photos.data.model

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PhotosListTypeConverter {

    private val gson = Gson()
    private val type = object : TypeToken<List<Photo>>() {}.type

    @TypeConverter
    fun fromPhotosListToString(photosList: List<Photo>?): String? {
        return if (photosList == null) null else gson.toJson(photosList, type)
    }

    @TypeConverter
    fun fromStringToPhotosList(json: String?): List<Photo>? {
        return json?.let { gson.fromJson(json, type) }
    }

}