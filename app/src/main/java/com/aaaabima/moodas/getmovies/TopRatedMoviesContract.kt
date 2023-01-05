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
 * @version TopRatedMoviesContract, v 0.1 05/01/23 16.40 by Abim (Moch Arya Bima A)
 */
interface TopRatedMoviesContract {

    interface Presenter : BasePresenter {

        fun getTopRatedMovies()
    }

    interface View : BaseView {

        fun setMovieResult(movies: List<MovieModel>)
    }
}