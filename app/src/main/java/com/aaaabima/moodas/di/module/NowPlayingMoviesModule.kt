/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2023 All Rights Reserved.
 */

package com.aaaabima.moodas.di.module

import com.aaaabima.moodas.di.PerActivity
import com.aaaabima.moodas.getmovies.NowPlayingMoviesContract
import com.aaaabima.moodas.getmovies.NowPlayingMoviesPresenter
import dagger.Module
import dagger.Provides

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version NowPlayingMoviesModule, v 0.1 06/01/23 10.14 by Abim (Moch Arya Bima A)
 */
@Module
class NowPlayingMoviesModule(
    private val view: NowPlayingMoviesContract.View
) {

    @PerActivity
    @Provides
    fun provideNowPlayingMoviesView(): NowPlayingMoviesContract.View = view

    @PerActivity
    @Provides
    fun provideNowPlayingMoviesPresenter(
        presenter: NowPlayingMoviesPresenter
    ): NowPlayingMoviesContract.Presenter = presenter
}