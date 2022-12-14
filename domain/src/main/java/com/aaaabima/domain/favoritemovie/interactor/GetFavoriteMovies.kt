/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.domain.favoritemovie.interactor

import com.aaaabima.domain.base.BaseUseCase
import com.aaaabima.domain.base.NoParams
import com.aaaabima.domain.favoritemovie.model.FavoriteMovie
import com.aaaabima.domain.favoritemovie.repository.FavoriteMovieRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version FavoriteMovie, v 0.1 12/14/2022 5:48 PM by Abim (Moch Arya Bima A)
 */
class GetFavoriteMovies @Inject constructor(
    private val favoriteMovieRepository: FavoriteMovieRepository
): BaseUseCase<NoParams, List<FavoriteMovie>>() {

    override fun buildUseCase(params: NoParams): Observable<List<FavoriteMovie>> {
        return favoriteMovieRepository.getFavoriteMovies()
    }
}