/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.data.apimovies.repository.source.network

import com.aaaabima.data.apimovies.mapper.toEntity
import com.aaaabima.data.apimovies.model.MovieEntity
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
): ApiMoviesEntityData {

    override fun getNowPlayingMovies(apiKey: String): Observable<List<MovieEntity>> {
        return movieAPI.getNowPlayingMovies(apiKey).map { response ->
            response.results?.map { movie ->
                movie.toEntity()
            }
        }
    }

    override fun getPopularMovies(apiKey: String): Observable<List<MovieEntity>> {
        return movieAPI.getPopularMovies(apiKey).map { response ->
            response.results?.map { movie ->
                movie!!.toEntity()
            }
        }
    }

    override fun getTopRatedMovies(apiKey: String): Observable<List<MovieEntity>> {
        return movieAPI.getTopRatedMovies(apiKey).map { response ->
            response.results?.map { movie ->
                movie!!.toEntity()
            }
        }
    }

    override fun getMovieDetail(apiKey: String, id: Int): Observable<MovieEntity> {
        return movieAPI.getMovieDetail(apiKey, id).map { response ->
            response.toEntity()
        }
    }

}