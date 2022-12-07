/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.moodas.getmovies

import com.aaaabima.domain.apimovies.interactor.GetNowPlayingMovies
import javax.inject.Inject

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version GetMoviesPresenter, v 0.1 06/12/22 15.41 by Abim (Moch Arya Bima A)
 */
class GetMoviesPresenter @Inject constructor(
    private val view: GetMoviesContract.View,
    private val getNowPlayingMovies: GetNowPlayingMovies
): GetMoviesContract.Presenter {

    override fun getNowPlayingMovies(apiKey: String) {
        TODO("Not yet implemented")
    }

    override fun resume() {
        TODO("Not yet implemented")
    }

    override fun pause() {
        TODO("Not yet implemented")
    }

    override fun destroy() {
        TODO("Not yet implemented")
    }
}