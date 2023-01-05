/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.domain.favoritemovie.interactor

import com.aaaabima.domain.base.BaseUseCase
import com.aaaabima.domain.favoritemovie.repository.FavoriteMovieRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version IsFavoriteMovie, v 0.1 12/14/2022 5:58 PM by Abim (Moch Arya Bima A)
 */
class IsFavoriteMovie @Inject constructor(
    private val favoriteMovieRepository: FavoriteMovieRepository
) : BaseUseCase<String, Boolean>() {

    override fun buildUseCase(params: String): Observable<Boolean> =
        favoriteMovieRepository.isFavoriteMovie(params)
}