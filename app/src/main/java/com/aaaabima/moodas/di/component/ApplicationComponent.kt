/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.moodas.di.component

import android.content.Context
import com.aaaabima.data.di.DatabaseModule
import com.aaaabima.data.di.NetworkModule
import com.aaaabima.domain.apimovies.repository.ApiMoviesRepository
import com.aaaabima.domain.favoritemovie.repository.FavoriteMovieRepository
import com.aaaabima.moodas.di.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version ApplicationComponent, v 0.1 06/12/22 15.42 by Abim (Moch Arya Bima A)
 */
@Singleton
@Component(
    modules = [
        ApplicationModule::class,
        NetworkModule::class,
        DatabaseModule::class
    ]
)
interface ApplicationComponent {

    fun context(): Context
    fun apiMoviesRepository(): ApiMoviesRepository
    fun favoriteMovieRepository(): FavoriteMovieRepository
}