/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.data.apimovies.repository.source.network

import com.aaaabima.data.BuildConfig
import com.aaaabima.data.apimovies.mapper.toEntity
import com.aaaabima.data.apimovies.model.MovieEntity
import com.aaaabima.data.apimovies.model.MovieTrailerEntity
import com.aaaabima.data.apimovies.repository.source.ApiMoviesEntityData
import com.aaaabima.data.network.MovieAPI
import io.reactivex.Observable
import javax.inject.Inject

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version NetworkApiMoviesEntityData, v 0.1 01/12/22 14.29 by Abim (Moch Arya Bima A)
 */
class NetworkApiMoviesEntityData @Inject constructor(
    private val movieAPI: MovieAPI
) : ApiMoviesEntityData {

    private val apiKey by lazy { BuildConfig.API_KEY }

    override fun getNowPlayingMovies(): Observable<List<MovieEntity>> {
        return movieAPI.getNowPlayingMovies(apiKey).map { response ->
            response.results?.map { movie ->
                movie.toEntity()
            }
        }
    }

    override fun getPopularMovies(): Observable<List<MovieEntity>> {
        return movieAPI.getPopularMovies(apiKey).map { response ->
            response.results?.map { movie ->
                movie.toEntity()
            }
        }
    }

    override fun getTopRatedMovies(): Observable<List<MovieEntity>> {
        return movieAPI.getTopRatedMovies(apiKey).map { response ->
            response.results?.map { movie ->
                movie.toEntity()
            }
        }
    }

    override fun getMovieDetail(id: Int): Observable<MovieEntity> {
        return movieAPI.getMovieDetail(id, apiKey).map { response ->
            response.toEntity()
        }
    }

    override fun getMovieTrailer(id: Int): Observable<List<MovieTrailerEntity>> {
        return movieAPI.getMovieTrailer(id, apiKey).map { response ->
            response.results?.map {
                it.toEntity()
            }
        }
    }
}