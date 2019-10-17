package com.example.flickrdemo.features.photos.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.flickrdemo.features.photos.data.model.PhotosListResponseModel
import io.reactivex.Single

@Dao
interface PhotosListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPhotosListResponse(photosListResponseModel: PhotosListResponseModel)

    @Query("SELECT * FROM PhotosListResponseModel WHERE pageNumber is :page")
    fun getPhotosListResponseByPage(page: Int): Single<PhotosListResponseModel>

}