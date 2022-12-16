/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.domain.favoritemovie.interactor

import com.aaaabima.domain.base.BaseUseCase
import com.aaaabima.domain.favoritemovie.model.DeleteFavoriteMovieRequest
import com.aaaabima.domain.favoritemovie.model.InsertFavoriteMovieRequest
import com.aaaabima.domain.favoritemovie.repository.FavoriteMovieRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version InsertFavoriteMovie, v 0.1 12/14/2022 5:58 PM by Abim (Moch Arya Bima A)
 */
class InsertFavoriteMovie @Inject constructor(
    private val favoriteMovieRepository: FavoriteMovieRepository
) : BaseUseCase<InsertFavoriteMovie.Params, Int>() {

    override fun buildUseCase(params: Params): Observable<Int> {
        return favoriteMovieRepository.insertFavoriteMovie(
            params.insertFavoriteMovieRequest.movie
        )
    }

    class Params constructor(internal val insertFavoriteMovieRequest: InsertFavoriteMovieRequest) {
        companion object {

            fun createInsertFavoriteMovieRequest(request: InsertFavoriteMovieRequest) =
                Params(request)
        }
    }
}