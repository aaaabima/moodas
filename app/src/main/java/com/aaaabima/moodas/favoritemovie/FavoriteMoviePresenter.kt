/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.moodas.favoritemovie

import com.aaaabima.domain.base.NoParams
import com.aaaabima.domain.favoritemovie.interactor.GetFavoriteMovies
import com.aaaabima.moodas.favoritemovie.mapper.toModel
import javax.inject.Inject

/**
 * @author Abim (Moch Arya Bima A (i-arya.agfian@dana.id)
 * @version FavoriteMoviePresenter, v 0.1 12/14/2022 1:34 PM by Abim (Moch Arya Bima A
 */
class FavoriteMoviePresenter @Inject constructor(
    private val view: FavoriteMovieContract.View,
    private val getFavoriteMovies: GetFavoriteMovies,
) : FavoriteMovieContract.Presenter {

    override fun getFavoriteMovies() {
        view.showProgress()
        getFavoriteMovies.execute(
            NoParams, onSuccess = { movie ->
                view.setFavoriteMovieResult(movie.map { it.toModel() })
                view.dismissProgress()
            }, onError = {
                view.onError(it.message)
                view.dismissProgress()
            }
        )
    }

    override fun resume() {
        // no implementation
    }

    override fun pause() {
        // no implementation
    }

    override fun destroy() {
        getFavoriteMovies.dispose()
    }
}