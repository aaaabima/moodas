/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.data.apimovies.repository

import com.aaaabima.data.apimovies.mapper.toDomain
import com.aaaabima.data.apimovies.model.MovieEntity
import com.aaaabima.data.apimovies.model.MovieTrailerEntity
import com.aaaabima.data.apimovies.repository.source.ApiMoviesEntityDataFactory
import com.aaaabima.data.util.SourceType
import com.aaaabima.domain.apimovies.model.Movie
import com.aaaabima.domain.apimovies.model.MovieTrailer
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

    override fun getNowPlayingMovies(): Observable<List<Movie>> {
        return getNowPlayingMoviesFromRemote()
    }

    override fun getPopularMovies(): Observable<List<Movie>> {
        TODO("Not yet implemented")
    }

    override fun getTopRatedMovies(): Observable<List<Movie>> {
        TODO("Not yet implemented")
    }

    override fun getMovieDetail(id: Int): Observable<Movie> {
        return getMovieDetailFromRemote(id)
    }

    override fun getMovieTrailer(id: Int): Observable<List<MovieTrailer>> {
        return getMovieTrailerFromRemote(id)
    }

    private fun getNowPlayingMoviesFromRemote(): Observable<List<Movie>> {
        return getRemoteRepository().getNowPlayingMovies()
            .flatMap { movieResult ->
                movieResult.mapListToDomain()
            }
    }

    private fun getMovieDetailFromRemote(id: Int): Observable<Movie> {
        return getRemoteRepository().getMovieDetail(id)
            .map { movieResult ->
                movieResult.toDomain()
            }
    }

    private fun getMovieTrailerFromRemote(id: Int): Observable<List<MovieTrailer>> {
        return getRemoteRepository().getMovieTrailer(id)
            .flatMap { movie ->
                movie.mapListToDomainTrailer()
            }
    }

    private fun List<MovieEntity>.mapListToDomain() =
        Observable.fromIterable(this)
            .map { it.toDomain() }
            .toList()
            .toObservable()

    private fun List<MovieTrailerEntity>.mapListToDomainTrailer() =
        Observable.fromIterable(this)
            .map { it.toDomain() }
            .toList()
            .toObservable()

}