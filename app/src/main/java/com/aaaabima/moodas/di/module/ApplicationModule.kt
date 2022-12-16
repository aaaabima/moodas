/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.moodas.di.module

import android.app.Application
import android.content.Context
import com.aaaabima.data.apimovies.repository.ApiMoviesEntityRepository
import com.aaaabima.data.favoritemovie.repository.FavoriteMovieEntityRepository
import com.aaaabima.domain.apimovies.repository.ApiMoviesRepository
import com.aaaabima.domain.favoritemovie.repository.FavoriteMovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version ApplicationComponent, v 0.1 06/12/22 15.41 by Abim (Moch Arya Bima A)
 */
@Module
class ApplicationModule(private val app: Application) {

    @Singleton
    @Provides
    fun provideContext(): Context = app

    @Singleton
    @Provides
    fun provideApplication(): Application = app

    @Singleton
    @Provides
    fun provideSearchUserRepository(
        apiMoviesEntityRepository: ApiMoviesEntityRepository
    ): ApiMoviesRepository =
        apiMoviesEntityRepository

    @Singleton
    @Provides
    fun provideFavoriteMovieRepository(
        favoriteMovieEntityRepository: FavoriteMovieEntityRepository
    ): FavoriteMovieRepository =
        favoriteMovieEntityRepository
}