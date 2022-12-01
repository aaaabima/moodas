/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.data.di

import com.aaaabima.data.BuildConfig
import com.aaaabima.data.network.MovieAPI
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version NetworkModule, v 0.1 01/12/22 13.19 by Abim (Moch Arya Bima A)
 */
@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideBaseURL() = BuildConfig.BASE_URL

    @Provides
    @Singleton
    fun HttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG)
                HttpLoggingInterceptor.Level.BODY
            else HttpLoggingInterceptor.Level.NONE
        }
    }

    @Provides
    @Singleton
    fun provideOkHttpClientBuilder(
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient.Builder =
        OkHttpClient.Builder()
            .writeTimeout(DEFAULT_TIME_OUT, TimeUnit.MILLISECONDS)
            .connectTimeout(DEFAULT_TIME_OUT, TimeUnit.MILLISECONDS)
            .readTimeout(DEFAULT_TIME_OUT, TimeUnit.MILLISECONDS)

    @Provides
    @Singleton
    fun provideRetrofitBuilder(
        baseUrl: String
    ): Retrofit.Builder =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())

    @Provides
    @Singleton
    fun provideMovieAPI(
        okHttpClientBuilder: OkHttpClient.Builder,
        retrofitBuilder: Retrofit.Builder
    ): MovieAPI =
        provideService(MovieAPI::class.java, okHttpClientBuilder, retrofitBuilder)

    private fun <S> provideService(
        serviceClass: Class<S>,
        okHttpClientBuilder: OkHttpClient.Builder,
        retrofitBuilder: Retrofit.Builder
    ): S {
        retrofitBuilder.client(okHttpClientBuilder.build())
        return retrofitBuilder.build().create(serviceClass)
    }

    private val DATE_FORMAT = "yyyy-MM-dd'T'hh:mm:ssZ"
    private val DEFAULT_TIME_OUT: Long = 30L * 1000
}