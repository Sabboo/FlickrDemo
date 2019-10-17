package com.example.flickrdemo

import android.app.Application
import android.content.Context
import com.example.flickrdemo.di.*
import com.facebook.stetho.Stetho
import org.koin.core.context.startKoin

internal class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
        startKoin {
            modules(
                listOf(
                    DaoModule,
                    NetworkModule,
                    RepositoryModule,
                    ViewModelModule,
                    WebServiceModule
                )
            )
        }
    }

    init {
        instance = this
    }

    companion object {
        private var instance = App()
        fun get(): Context {
            return instance
        }
    }
}