/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.moodas.moviedetail

import com.aaaabima.domain.apimovies.interactor.GetMovieDetail
import com.aaaabima.domain.apimovies.interactor.GetMovieTrailer
import com.aaaabima.domain.favoritemovie.interactor.DeleteFavoriteMovie
import com.aaaabima.domain.favoritemovie.interactor.InsertFavoriteMovie
import com.aaaabima.domain.favoritemovie.interactor.IsFavoriteMovie
import com.aaaabima.domain.favoritemovie.model.DeleteFavoriteMovieRequest
import com.aaaabima.domain.favoritemovie.model.InsertFavoriteMovieRequest
import com.aaaabima.domain.favoritemovie.model.IsFavoriteMovieRequest
import com.aaaabima.moodas.favoritemovie.mapper.toDomain
import com.aaaabima.moodas.favoritemovie.model.FavoriteMovieModel
import com.aaaabima.moodas.getmovies.mapper.toModel
import javax.inject.Inject

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version MovieDetailPresenter, v 0.1 06/12/22 15.38 by Abim (Moch Arya Bima A)
 */
class MovieDetailPresenter @Inject constructor(
    private val view: MovieDetailContract.View,
    private val getMovieDetail: GetMovieDetail,
    private val getMovieTrailer: GetMovieTrailer,
    private val insertFavoriteMovie: InsertFavoriteMovie,
    private val deleteFavoriteMovie: DeleteFavoriteMovie,
    private val isFavoriteMovie: IsFavoriteMovie,
) : MovieDetailContract.Presenter {

    override fun getMovieDetail(id: Int) {
        view.showProgress()
        getMovieDetail.execute(
            params = id, onSuccess = { movie ->
                view.setMovieResult(movie.toModel())
                view.dismissProgress()
            }, onError = {
                view.onError(it.message)
                view.dismissProgress()
            }
        )
    }

    override fun getMovieTrailer(id: Int) {
        view.showProgress()
        getMovieTrailer.execute(
            params = id, onSuccess = { trailer ->
                view.setMovieTrailerResult(trailer.map { it.toModel() })
                view.dismissProgress()
            }, onError = {
                view.onError(it.message)
                view.dismissProgress()
            }
        )
    }

    override fun insertFavoriteMovie(movie: FavoriteMovieModel) {
        view.showProgress()
        insertFavoriteMovie.execute(
            InsertFavoriteMovie.Params.createInsertFavoriteMovieRequest(
                InsertFavoriteMovieRequest(movie.toDomain())
            ), onSuccess = {
                view.dismissProgress()
            }, onError = {
                view.onError(it.message)
                view.dismissProgress()
            }
        )
    }

    override fun deleteFavoriteMovie(movie: FavoriteMovieModel) {
        view.showProgress()
        deleteFavoriteMovie.execute(
            DeleteFavoriteMovie.Params.createDeleteFavoriteMovieRequest(
                DeleteFavoriteMovieRequest(movie.toDomain())
            ), onSuccess = {
                view.dismissProgress()
            }, onError = {
                view.onError(it.message)
                view.dismissProgress()
            }
        )
    }

    override fun isFavoriteMovie(id: String) {
        view.showProgress()
        isFavoriteMovie.execute(
            IsFavoriteMovie.Params.createInsertFavoriteMovieRequest(
                IsFavoriteMovieRequest(id)
            ), onSuccess = { result ->
                view.dismissProgress()
                view.setFavoriteState(result)
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
        getMovieDetail.dispose()
    }

    fun formatDisplayText(prefix: String, text: String): String {
        return "$prefix : $text"
    }

    fun formatGenre(genres: List<String>): String {
        var text = ""
        for (genre in genres)
            text += "| $genre "
        return "$text |"
    }

    fun formatRuntime(runtime: Int): String {
        return "${runtime / 60} hr ${runtime % 60} minute"
    }
}