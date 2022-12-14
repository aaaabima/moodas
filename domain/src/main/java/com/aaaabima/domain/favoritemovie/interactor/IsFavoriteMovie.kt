/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.domain.favoritemovie.interactor

import com.aaaabima.domain.base.BaseUseCase
import com.aaaabima.domain.favoritemovie.model.InsertFavoriteMovieRequest
import com.aaaabima.domain.favoritemovie.model.IsFavoriteMovieRequest
import com.aaaabima.domain.favoritemovie.repository.FavoriteMovieRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version IsFavoriteMovie, v 0.1 12/14/2022 5:58 PM by Abim (Moch Arya Bima A)
 */
class IsFavoriteMovie @Inject constructor(
    private val favoriteMovieRepository: FavoriteMovieRepository
) : BaseUseCase<IsFavoriteMovie.Params, Boolean>() {

    override fun buildUseCase(params: Params): Observable<Boolean> {
        return favoriteMovieRepository.isFavoriteMovie(
            params.isFavoriteMovie.id
        )
    }

    class Params constructor(internal val isFavoriteMovie: IsFavoriteMovieRequest) {
        companion object {

            fun createInsertFavoriteMovieRequest(request: IsFavoriteMovieRequest) =
                Params(request)
        }
    }
}