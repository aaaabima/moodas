/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2023 All Rights Reserved.
 */

package com.aaaabima.domain.apimovies.interactor

import com.aaaabima.domain.apimovies.model.Movie
import com.aaaabima.domain.apimovies.repository.ApiMoviesRepository
import com.aaaabima.domain.base.BaseUseCase
import com.aaaabima.domain.base.NoParams
import io.reactivex.Observable
import javax.inject.Inject

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version GetTopRatedMovies, v 0.1 05/01/23 14.31 by Abim (Moch Arya Bima A)
 */
class GetTopRatedMovies @Inject constructor(
    private val apiMoviesRepository: ApiMoviesRepository
) : BaseUseCase<NoParams, List<Movie>>() {

    override fun buildUseCase(params: NoParams): Observable<List<Movie>> =
        apiMoviesRepository.getTopRatedMovies()
}