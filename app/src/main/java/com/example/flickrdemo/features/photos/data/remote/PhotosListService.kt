package com.example.flickrdemo.features.photos.data.remote

import com.example.flickrdemo.features.photos.data.model.PhotosListServerResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface PhotosListService {

    @GET("rest/")
    fun getPhotosList(
        @Query("api_key") apiKey: String,
        @Query("format") format: String,
        @Query("method") method: String,
        @Query("per_page") per_page: String,
        @Query("page") page: String,
        @Query("nojsoncallback") jsonCallback: String
    ): Single<PhotosListServerResponse>

}