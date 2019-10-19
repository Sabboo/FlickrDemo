package com.example.flickrdemo.features.photos.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Photo(
    @SerializedName("id") val id: String,
    @SerializedName("secret") val secret: String,
    @SerializedName("server") val server: String,
    @SerializedName("farm") val farm: String
) : Parcelable {
    fun photoURL() = String.format(
        "https://farm%s.staticflickr.com/%s/%s_%s.jpg",
        farm, server, id, secret
    )
}