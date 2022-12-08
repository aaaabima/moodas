/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.domain.apimovies.repository

import com.aaaabima.domain.apimovies.model.Movie
import io.reactivex.Observable

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version ApiMoviesRepository, v 0.1 01/12/22 11.16 by Abim (Moch Arya Bima A)
 */
interface ApiMoviesRepository {

    fun getNowPlayingMovies(
        apiKey: String,
        refresh: Boolean
    ): Observable<List<Movie>>

    fun getPopularMovies(
        apiKey: String,
        refresh: Boolean
    ): Observable<List<Movie>>

    fun getTopRatedMovies(
        apiKey: String,
        refresh: Boolean
    ): Observable<List<Movie>>

    fun getMovieDetail(
        apiKey: String,
        id: Int
    ): Observable<Movie>

}