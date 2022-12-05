/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.domain.apimovies.interactor

import com.aaaabima.domain.apimovies.model.GetNowPlayingMoviesRequest
import com.aaaabima.domain.apimovies.model.Movie
import com.aaaabima.domain.apimovies.repository.ApiMoviesRepository
import com.aaaabima.domain.base.BaseUseCase
import io.reactivex.Observable
import javax.inject.Inject

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version GetMoviesByType, v 0.1 05/12/22 09.07 by Abim (Moch Arya Bima A)
 */
class GetNowPlayingMovies @Inject constructor(
    private val apiMoviesRepository: ApiMoviesRepository
) : BaseUseCase<GetNowPlayingMovies.Params, List<Movie>>() {

    override fun buildUseCase(params: Params): Observable<List<Movie>> {
        return apiMoviesRepository.getNowPlayingMovies(
            params.getNowPlayingMoviesRequest.refresh
        )
    }

    class Params constructor(internal val getNowPlayingMoviesRequest: GetNowPlayingMoviesRequest) {
        companion object {

            fun createGetMoviesRequest(request: GetNowPlayingMoviesRequest) = Params(request)
        }
    }
}