/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2023 All Rights Reserved.
 */

package com.aaaabima.moodas.getmovies

import com.aaaabima.domain.apimovies.interactor.GetNowPlayingMovies
import com.aaaabima.domain.base.NoParams
import com.aaaabima.moodas.getmovies.mapper.toModel
import javax.inject.Inject

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version NowPlayingMoviesPresenter, v 0.1 05/01/23 16.33 by Abim (Moch Arya Bima A)
 */
class NowPlayingMoviesPresenter @Inject constructor(
    private val view: NowPlayingMoviesContract.View,
    private val getNowPlayingMovies: GetNowPlayingMovies
) : NowPlayingMoviesContract.Presenter {

    override fun getNowPlayingMovies() {
        view.showProgress()
        getNowPlayingMovies.execute(
            params = NoParams, onSuccess = { movieResult ->
                view.setMovieResult(movieResult.map { it.toModel() })
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
        getNowPlayingMovies.dispose()
    }
}