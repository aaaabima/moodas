/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
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
 * @version GetNowPlayingMovies, v 0.1 05/12/22 09.07 by Abim (Moch Arya Bima A)
 */
class GetNowPlayingMovies @Inject constructor(
    private val apiMoviesRepository: ApiMoviesRepository
) : BaseUseCase<NoParams, List<Movie>>() {

    override fun buildUseCase(params: NoParams): Observable<List<Movie>> =
        apiMoviesRepository.getNowPlayingMovies()
}