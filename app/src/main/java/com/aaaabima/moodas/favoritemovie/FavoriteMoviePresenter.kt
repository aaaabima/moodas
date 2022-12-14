/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.moodas.favoritemovie

import com.aaaabima.domain.favoritemovie.interactor.DeleteFavoriteMovie
import com.aaaabima.domain.favoritemovie.interactor.GetFavoriteMovies
import com.aaaabima.domain.favoritemovie.interactor.InsertFavoriteMovie
import com.aaaabima.domain.favoritemovie.interactor.IsFavoriteMovie
import com.aaaabima.moodas.favoritemovie.model.FavoriteMovieModel
import javax.inject.Inject

/**
 * @author Abim (Moch Arya Bima A (i-arya.agfian@dana.id)
 * @version FavoriteMoviePresenter, v 0.1 12/14/2022 1:34 PM by Abim (Moch Arya Bima A
 */
class FavoriteMoviePresenter @Inject constructor(
    private val view: FavoriteMovieContract.View,
    private val getFavoriteMovies: GetFavoriteMovies,
    private val insertFavoriteMovie: InsertFavoriteMovie,
    private val deleteFavoriteMovie: DeleteFavoriteMovie,
    private val isFavoriteMovie: IsFavoriteMovie
): FavoriteMovieContract.Presenter {

    override fun getFavoriteMovies() {
        TODO("Not yet implemented")
    }

    override fun insertFavoriteMovie(movie: FavoriteMovieModel) {
        TODO("Not yet implemented")
    }

    override fun deleteFavoriteMovie(movie: FavoriteMovieModel) {
        TODO("Not yet implemented")
    }

    override fun isFavoriteMovie(id: String) {
        TODO("Not yet implemented")
    }

    override fun resume() {
        // no implementation
    }

    override fun pause() {
        // no implementation
    }

    override fun destroy() {
        getFavoriteMovies.dispose()
        insertFavoriteMovie.dispose()
        deleteFavoriteMovie.dispose()
        isFavoriteMovie.dispose()
    }
}