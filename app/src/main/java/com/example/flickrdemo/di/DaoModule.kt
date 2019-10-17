package com.example.flickrdemo.di

import com.example.flickrdemo.App.Companion.get
import com.example.flickrdemo.AppDatabase
import com.example.flickrdemo.features.photos.data.local.PhotosListDao
import org.koin.dsl.module

val DaoModule = module {

    single { providePhotosListDao() }

}

fun providePhotosListDao(): PhotosListDao {
    val db = AppDatabase(get())
    return db.photosListDao()
}
