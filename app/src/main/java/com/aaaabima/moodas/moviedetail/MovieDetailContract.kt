/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.moodas.moviedetail

import com.aaaabima.moodas.base.BasePresenter
import com.aaaabima.moodas.base.BaseView
import com.aaaabima.moodas.favoritemovie.model.FavoriteMovieModel
import com.aaaabima.moodas.getmovies.model.MovieModel
import com.aaaabima.moodas.moviedetail.model.MovieTrailerModel

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version MovieDetailContract, v 0.1 06/12/22 15.38 by Abim (Moch Arya Bima A)
 */
interface MovieDetailContract {

    interface Presenter : BasePresenter {

        fun getMovieDetail(id: Int)

        fun getMovieTrailer(id: Int)

        fun insertFavoriteMovie(movie: FavoriteMovieModel)

        fun deleteFavoriteMovie(movie: FavoriteMovieModel)

        fun isFavoriteMovie(id: String)
    }

    interface View : BaseView {

        fun setMovieResult(movie: MovieModel)

        fun setMovieTrailerResult(trailer: List<MovieTrailerModel>)

        fun setFavoriteState(isFavorite: Boolean)
    }
}