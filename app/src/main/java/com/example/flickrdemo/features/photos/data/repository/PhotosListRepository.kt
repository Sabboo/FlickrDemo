package com.example.flickrdemo.features.photos.data.repository

import com.example.flickrdemo.features.photos.data.local.PhotosListDao
import com.example.flickrdemo.features.photos.data.model.PhotosListServerResponse
import com.example.flickrdemo.features.photos.data.remote.PhotosListService
import com.example.flickrdemo.utilities.Constants
import com.example.flickrdemo.utilities.Constants.Companion.API_KEY
import com.example.flickrdemo.utilities.Constants.Companion.PHOTOS_PAGE_LIMIT
import com.example.flickrdemo.utilities.Constants.Companion.SERVICE_RESPONSE_TYPE
import io.reactivex.Single

class PhotosListRepository(
    private val remoteDataSource: PhotosListService,
    private val localDataSource: PhotosListDao
) {

    fun getPhotosList(page: Int): Single<PhotosListServerResponse> {

        return remoteDataSource.getPhotosList(
            API_KEY,
            SERVICE_RESPONSE_TYPE,
            Constants.API_METHOD_NAME,
            PHOTOS_PAGE_LIMIT.toString(),
            page.toString(), "1"
        )
            .doOnSuccess {
                it?.let {
                    it.pageNumber = page
                    localDataSource.insertPhotosListResponse(it)
                }
            }.onErrorResumeNext {
                localDataSource.getPhotosListResponseByPage(page)
            }
    }

}