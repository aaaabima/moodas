/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2023 All Rights Reserved.
 */

package com.aaaabima.moodas.getmovies

import com.aaaabima.domain.apimovies.interactor.GetPopularMovies
import com.aaaabima.domain.base.NoParams
import com.aaaabima.moodas.getmovies.mapper.toModel
import javax.inject.Inject

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version PopularMoviesPresenter, v 0.1 05/01/23 16.38 by Abim (Moch Arya Bima A)
 */
class PopularMoviesPresenter @Inject constructor(
    private val view: PopularMoviesContract.View,
    private val getPopularMovies: GetPopularMovies
) : PopularMoviesContract.Presenter {

    override fun getPopularMovies() {
        view.showProgress()
        getPopularMovies.execute(
            params = NoParams, onSuccess = { movies ->
                view.setMovieResult(movies.map { it.toModel() })
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
        getPopularMovies.dispose()
    }
}