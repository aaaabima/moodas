/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.moodas.di.module

import com.aaaabima.moodas.di.PerActivity
import com.aaaabima.moodas.moviedetail.MovieDetailContract
import com.aaaabima.moodas.moviedetail.MovieDetailPresenter
import dagger.Module
import dagger.Provides

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version MovieDetailModule, v 0.1 06/12/22 15.42 by Abim (Moch Arya Bima A)
 */
@Module
class MovieDetailModule(
    private val view: MovieDetailContract.View
) {

    @PerActivity
    @Provides
    fun provideGetMovieDetailView(): MovieDetailContract.View = view

    @PerActivity
    @Provides
    fun provideGetMovieDetailPresenter(
        presenter: MovieDetailPresenter
    ): MovieDetailContract.Presenter = presenter
}