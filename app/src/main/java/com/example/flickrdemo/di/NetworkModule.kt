package com.example.flickrdemo.di

import com.example.flickrdemo.utilities.Constants.Companion.FLICKR_SERVICE_BASE_URL
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val NetworkModule = module {
    single { provideGson() }
    single { provideLoggingInterceptor() }
    single { provideOkHttpClient(get()) }
    single { provideRetrofit(get(), get()) }
}


fun provideGson(): Gson {
    val gsonBuilder = GsonBuilder()
    gsonBuilder.setPrettyPrinting()
    gsonBuilder.setLenient()
    return gsonBuilder.create()
}

fun provideLoggingInterceptor(): HttpLoggingInterceptor {
    val logging = HttpLoggingInterceptor()
    logging.apply { this.level = HttpLoggingInterceptor.Level.BODY }
    return logging
}

fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
    val builder = OkHttpClient.Builder()
    builder.addInterceptor(loggingInterceptor)
    return builder.build()
}

fun provideRetrofit(client: OkHttpClient, gson: Gson): Retrofit {
    return Retrofit.Builder()
        .client(client)
        .baseUrl(FLICKR_SERVICE_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
}