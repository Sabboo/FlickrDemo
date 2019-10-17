package com.example.flickrdemo.features.photos.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.flickrdemo.features.photos.data.model.PhotosListServerResponse
import io.reactivex.Single

@Dao
interface PhotosListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPhotosListResponse(photosListServerResponse: PhotosListServerResponse)

    @Query("SELECT * FROM PhotosListServerResponse WHERE pageNumber is :page")
    fun getPhotosListResponseByPage(page: Int): Single<PhotosListServerResponse>

}