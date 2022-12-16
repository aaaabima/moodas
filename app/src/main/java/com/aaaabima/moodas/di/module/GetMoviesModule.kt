/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.moodas.di.module

import com.aaaabima.moodas.di.PerActivity
import com.aaaabima.moodas.getmovies.GetMoviesContract
import com.aaaabima.moodas.getmovies.GetMoviesPresenter
import dagger.Module
import dagger.Provides

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version GetMoviesModule, v 0.1 06/12/22 15.41 by Abim (Moch Arya Bima A)
 */
@Module
class GetMoviesModule(
    private val view: GetMoviesContract.View
) {

    @PerActivity
    @Provides
    fun provideGetMoviesView(): GetMoviesContract.View = view

    @PerActivity
    @Provides
    fun provideGetMoviesPresenter(
        presenter: GetMoviesPresenter
    ): GetMoviesContract.Presenter = presenter
}