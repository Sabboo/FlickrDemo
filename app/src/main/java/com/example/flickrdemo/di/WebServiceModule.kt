package com.example.flickrdemo.di

import com.example.flickrdemo.features.photos.data.remote.PhotosListService
import org.koin.dsl.module
import retrofit2.Retrofit

val WebServiceModule = module {

    factory { providePhotosListService(get()) }

}

fun providePhotosListService(retrofit: Retrofit): PhotosListService {
    return retrofit.create(PhotosListService::class.java)
}
