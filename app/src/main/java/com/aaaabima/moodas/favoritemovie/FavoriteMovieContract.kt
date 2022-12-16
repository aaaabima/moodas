/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.moodas.favoritemovie

import com.aaaabima.moodas.base.BasePresenter
import com.aaaabima.moodas.base.BaseView
import com.aaaabima.moodas.favoritemovie.model.FavoriteMovieModel
import com.aaaabima.moodas.getmovies.model.MovieModel

/**
 * @author Abim (Moch Arya Bima A (i-arya.agfian@dana.id)
 * @version FavoriteMovieContract, v 0.1 12/14/2022 1:34 PM by Abim (Moch Arya Bima A
 */
interface FavoriteMovieContract {

    interface Presenter : BasePresenter {

        fun getFavoriteMovies()
    }

    interface View : BaseView {

        fun setFavoriteMovieResult(movies: List<FavoriteMovieModel>)
    }
}