package com.example.flickrdemo

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.flickrdemo.features.photos.data.local.PhotosListDao
import com.example.flickrdemo.features.photos.data.model.PhotosListResponseModel
import com.example.flickrdemo.features.photos.data.model.PhotosListTypeConverter

@Database(
    entities = [PhotosListResponseModel::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(PhotosListTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun photosListDao(): PhotosListDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context,
            AppDatabase::class.java, "flickr_demo.db"
        ).build()
    }

}