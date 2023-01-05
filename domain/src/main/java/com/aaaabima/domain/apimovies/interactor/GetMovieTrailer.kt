/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.domain.apimovies.interactor

import com.aaaabima.domain.apimovies.model.MovieTrailer
import com.aaaabima.domain.apimovies.repository.ApiMoviesRepository
import com.aaaabima.domain.base.BaseUseCase
import io.reactivex.Observable
import javax.inject.Inject

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version GetMovieTrailer, v 0.1 2022/12/16 17:51 by Abim (Moch Arya Bima A)
 */
class GetMovieTrailer @Inject constructor(
    private val apiMoviesRepository: ApiMoviesRepository
) : BaseUseCase<Int, List<MovieTrailer>>() {

    override fun buildUseCase(params: Int): Observable<List<MovieTrailer>> =
        apiMoviesRepository.getMovieTrailer(params)
}