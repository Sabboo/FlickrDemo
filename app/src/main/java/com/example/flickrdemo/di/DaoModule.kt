package com.example.flickrdemo.di

import com.example.flickrdemo.App
import com.example.flickrdemo.AppDatabase
import com.example.flickrdemo.features.photos.data.local.PhotosListDao
import org.koin.dsl.module

val DaoModule = module {

    single { provideCategoriesDao() }

}

fun provideCategoriesDao(): PhotosListDao {
    val db = AppDatabase(App.get())
    return db.photosListDao()
}
