/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2023 All Rights Reserved.
 */

package com.aaaabima.moodas.di.module

import com.aaaabima.moodas.di.PerActivity
import com.aaaabima.moodas.getmovies.TopRatedMoviesContract
import dagger.Module
import dagger.Provides

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version TopRatedMoviesModule, v 0.1 06/01/23 11.07 by Abim (Moch Arya Bima A)
 */
@Module
class TopRatedMoviesModule(
    private val view: TopRatedMoviesContract.View
) {

    @PerActivity
    @Provides
    fun provideTopRatedMoviesView(): TopRatedMoviesContract.View = view

    @PerActivity
    @Provides
    fun provideTopRatedMoviesPresenter(
        presenter: TopRatedMoviesContract.Presenter
    ): TopRatedMoviesContract.Presenter = presenter
}