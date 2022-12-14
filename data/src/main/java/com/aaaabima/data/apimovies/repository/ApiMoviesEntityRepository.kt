/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.data.apimovies.repository

import com.aaaabima.data.apimovies.mapper.toDomain
import com.aaaabima.data.apimovies.model.MovieEntity
import com.aaaabima.data.apimovies.repository.source.ApiMoviesEntityDataFactory
import com.aaaabima.data.util.SourceType
import com.aaaabima.domain.apimovies.model.Movie
import com.aaaabima.domain.apimovies.repository.ApiMoviesRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version ApiMoviesEntityRepository, v 0.1 01/12/22 14.26 by Abim (Moch Arya Bima A)
 */
class ApiMoviesEntityRepository @Inject constructor(
    private val apiMoviesEntityDataFactory: ApiMoviesEntityDataFactory
) : ApiMoviesRepository {

    private fun getRemoteRepository() =
        apiMoviesEntityDataFactory.createApiMoviesEntityData(SourceType.NETWORK)

    override fun getNowPlayingMovies(apiKey: String, refresh: Boolean): Observable<List<Movie>> {
        return getNowPlayingMoviesFromRemote(apiKey)
    }

    override fun getPopularMovies(apiKey: String, refresh: Boolean): Observable<List<Movie>> {
        TODO("Not yet implemented")
    }

    override fun getTopRatedMovies(apiKey: String, refresh: Boolean): Observable<List<Movie>> {
        TODO("Not yet implemented")
    }

    override fun getMovieDetail(id: Int, apiKey: String, ): Observable<Movie> {
        return getMovieDetailFromRemote(id, apiKey)
    }

    private fun getNowPlayingMoviesFromRemote(
        apiKey: String
    ): Observable<List<Movie>> {
        return getRemoteRepository().getNowPlayingMovies(apiKey)
            .flatMap { movieResult ->
                movieResult.mapListToDomain()
            }
    }

    private fun getMovieDetailFromRemote(
        id: Int,
        apiKey: String,
    ): Observable<Movie> {
        return getRemoteRepository().getMovieDetail(id, apiKey)
            .map { movieResult ->
                movieResult.toDomain()
            }
    }

    private fun List<MovieEntity>.mapListToDomain() =
        Observable.fromIterable(this)
            .map { it.toDomain() }
            .toList()
            .toObservable()

}