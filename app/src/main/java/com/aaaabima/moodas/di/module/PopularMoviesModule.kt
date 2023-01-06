/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2023 All Rights Reserved.
 */

package com.aaaabima.moodas.di.module

import com.aaaabima.moodas.di.PerActivity
import com.aaaabima.moodas.getmovies.PopularMoviesContract
import dagger.Module
import dagger.Provides

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version PopularMoviesModule, v 0.1 06/01/23 11.07 by Abim (Moch Arya Bima A)
 */
@Module
class PopularMoviesModule(
    private val view: PopularMoviesContract.View
) {

    @PerActivity
    @Provides
    fun providePopularMoviesView(): PopularMoviesContract.View = view

    @PerActivity
    @Provides
    fun providePopularMoviesPresenter(
        presenter: PopularMoviesContract.Presenter
    ): PopularMoviesContract.Presenter = presenter
}