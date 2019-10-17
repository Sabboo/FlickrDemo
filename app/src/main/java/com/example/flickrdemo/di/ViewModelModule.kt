package com.example.flickrdemo.di

import com.example.flickrdemo.features.photos.presentation.PhotosListViewModel
import org.koin.dsl.module

val ViewModelModule = module {

    factory { PhotosListViewModel(get()) }

}