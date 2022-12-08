/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.moodas.getmovies

import com.aaaabima.moodas.base.BasePresenter
import com.aaaabima.moodas.base.BaseView
import com.aaaabima.moodas.getmovies.model.MovieModel

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version GetMoviesContract, v 0.1 06/12/22 15.41 by Abim (Moch Arya Bima A)
 */
interface GetMoviesContract {
    interface Presenter: BasePresenter {
        fun getNowPlayingMovies(apiKey: String, refresh: Boolean)
    }

    interface View: BaseView {
        fun setMovieResult(movies: List<MovieModel>)
    }
}