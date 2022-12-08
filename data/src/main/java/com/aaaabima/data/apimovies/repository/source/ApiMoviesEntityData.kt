/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.data.apimovies.repository.source

import com.aaaabima.data.apimovies.model.MovieEntity
import io.reactivex.Observable

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version ApiMoviesEntityData, v 0.1 01/12/22 14.28 by Abim (Moch Arya Bima A)
 */
interface ApiMoviesEntityData {

    fun getNowPlayingMovies(apiKey: String): Observable<List<MovieEntity>>

    fun getPopularMovies(apiKey: String): Observable<List<MovieEntity>>

    fun getTopRatedMovies(apiKey: String): Observable<List<MovieEntity>>

    fun getMovieDetail(
        id: Int,
        apiKey: String,
    ): Observable<MovieEntity>
}
