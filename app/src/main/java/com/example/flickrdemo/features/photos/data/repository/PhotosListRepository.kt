package com.example.flickrdemo.features.photos.data.repository

import com.example.flickrdemo.features.photos.data.local.PhotosListDao
import com.example.flickrdemo.features.photos.data.model.PhotosListResponseModel
import com.example.flickrdemo.features.photos.data.remote.PhotosListService
import com.example.flickrdemo.utilities.Constants.Companion.API_KEY
import com.example.flickrdemo.utilities.Constants.Companion.LIST_OF_PHOTOS_SERVICE_END_POINT
import com.example.flickrdemo.utilities.Constants.Companion.PHOTOS_PAGE_LIMIT
import com.example.flickrdemo.utilities.Constants.Companion.SERVICE_RESPONSE_TYPE
import io.reactivex.Single
import org.koin.core.KoinComponent
import org.koin.core.inject

class PhotosListRepository : KoinComponent {

    private val remoteDataSource by inject<PhotosListService>()
    private val localDataSource by inject<PhotosListDao>()

    fun getPhotosList(page: Int): Single<PhotosListResponseModel> {

        return remoteDataSource.getPhotosList(
            LIST_OF_PHOTOS_SERVICE_END_POINT, API_KEY,
            SERVICE_RESPONSE_TYPE, PHOTOS_PAGE_LIMIT.toString(), page.toString()
        )
            .doOnSuccess { photosListResponseModel: PhotosListResponseModel? ->
                photosListResponseModel?.let {
                    localDataSource.insertPhotosListResponse(it)
                }
            }.onErrorResumeNext {
                localDataSource.getPhotosListResponseByPage(
                    page
                )
            }
    }

}