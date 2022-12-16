/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.moodas.di.module

import com.aaaabima.moodas.di.PerActivity
import com.aaaabima.moodas.favoritemovie.FavoriteMovieContract
import com.aaaabima.moodas.favoritemovie.FavoriteMoviePresenter
import dagger.Module
import dagger.Provides

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version FavoriteMovieModule, v 0.1 12/14/2022 10:57 PM by Abim (Moch Arya Bima A)
 */
@Module
class FavoriteMovieModule(
    private val view: FavoriteMovieContract.View
) {

    @PerActivity
    @Provides
    fun provideFavoriteMovieView(): FavoriteMovieContract.View = view

    @PerActivity
    @Provides
    fun provideFavoriteMoviePresenter(
        presenter: FavoriteMoviePresenter
    ): FavoriteMovieContract.Presenter = presenter
}