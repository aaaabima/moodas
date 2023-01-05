/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.domain.apimovies.repository

import com.aaaabima.domain.apimovies.model.Movie
import com.aaaabima.domain.apimovies.model.MovieTrailer
import io.reactivex.Observable

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version ApiMoviesRepository, v 0.1 01/12/22 11.16 by Abim (Moch Arya Bima A)
 */
interface ApiMoviesRepository {

    fun getNowPlayingMovies(): Observable<List<Movie>>

    fun getPopularMovies(): Observable<List<Movie>>

    fun getTopRatedMovies(): Observable<List<Movie>>

    fun getMovieDetail(id: Int): Observable<Movie>

    fun getMovieTrailer(id: Int): Observable<List<MovieTrailer>>
}