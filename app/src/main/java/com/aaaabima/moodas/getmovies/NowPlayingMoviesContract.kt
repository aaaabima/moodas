/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2023 All Rights Reserved.
 */

package com.aaaabima.moodas.getmovies

import com.aaaabima.moodas.base.BasePresenter
import com.aaaabima.moodas.base.BaseView
import com.aaaabima.moodas.getmovies.model.MovieModel

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version NowPlayingMoviesContract, v 0.1 05/01/23 16.34 by Abim (Moch Arya Bima A)
 */
interface NowPlayingMoviesContract {

    interface Presenter : BasePresenter {

        fun getNowPlayingMovies()
    }

    interface View : BaseView {

        fun setMovieResult(movies: List<MovieModel>)
    }
}