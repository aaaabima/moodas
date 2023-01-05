/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2023 All Rights Reserved.
 */

package com.aaaabima.moodas.getmovies

import com.aaaabima.domain.apimovies.interactor.GetTopRatedMovies
import com.aaaabima.domain.base.NoParams
import com.aaaabima.moodas.getmovies.mapper.toModel
import javax.inject.Inject

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version TopRatedMoviesPresenter, v 0.1 05/01/23 16.40 by Abim (Moch Arya Bima A)
 */
class TopRatedMoviesPresenter @Inject constructor(
    private val view: TopRatedMoviesContract.View,
    private val getTopRatedMovies: GetTopRatedMovies
) : TopRatedMoviesContract.Presenter {

    override fun getTopRatedMovies() {
        view.showProgress()
        getTopRatedMovies.execute(
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
        getTopRatedMovies.dispose()
    }

}