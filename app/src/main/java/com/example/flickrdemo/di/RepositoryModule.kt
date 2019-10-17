package com.example.flickrdemo.di

import com.example.flickrdemo.features.photos.data.repository.PhotosListRepository
import org.koin.dsl.module

val RepositoryModule = module {

    single { PhotosListRepository() }

}