package com.example.flickrdemo.features.photos.data.remote

import com.example.flickrdemo.features.photos.data.model.PhotosListResponseModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface PhotosListService {

    @GET
    fun getPhotosList(
        @Url url: String,
        @Query("api_key") apiKey: String,
        @Query("format") format: String,
        @Query("per_page") per_page: String,
        @Query("page") page: String
    ): Single<PhotosListResponseModel>

}