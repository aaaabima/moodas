/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.moodas.getmovies

import com.aaaabima.domain.apimovies.interactor.GetNowPlayingMovies
import com.aaaabima.domain.apimovies.model.GetNowPlayingMoviesRequest
import com.aaaabima.moodas.getmovies.mapper.toModel
import javax.inject.Inject

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version GetMoviesPresenter, v 0.1 06/12/22 15.41 by Abim (Moch Arya Bima A)
 */
class GetMoviesPresenter @Inject constructor(
    private val view: GetMoviesContract.View,
    private val getNowPlayingMovies: GetNowPlayingMovies
) : GetMoviesContract.Presenter {

    override fun getNowPlayingMovies(apiKey: String, refresh: Boolean) {
        view.showProgress()
        getNowPlayingMovies.execute(
            GetNowPlayingMovies.Params.createGetMoviesRequest(
                GetNowPlayingMoviesRequest(apiKey)
            ), onSuccess = { movieResult ->
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