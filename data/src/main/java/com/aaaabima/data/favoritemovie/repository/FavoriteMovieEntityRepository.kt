/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.data.favoritemovie.repository

import com.aaaabima.data.apimovies.mapper.toDomain
import com.aaaabima.data.apimovies.model.MovieEntity
import com.aaaabima.data.favoritemovie.mapper.toDomain
import com.aaaabima.data.favoritemovie.model.FavoriteMovieEntity
import com.aaaabima.data.favoritemovie.repository.source.FavoriteMovieEntityDataFactory
import com.aaaabima.data.util.SourceType
import com.aaaabima.domain.favoritemovie.model.FavoriteMovie
import com.aaaabima.domain.favoritemovie.repository.FavoriteMovieRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version FavoriteMovieEntityRepository, v 0.1 12/14/2022 5:39 PM by Abim (Moch Arya Bima A)
 */
class FavoriteMovieEntityRepository @Inject constructor(
    private val favoriteMovieEntityDataFactory: FavoriteMovieEntityDataFactory
): FavoriteMovieRepository {

    private fun getLocalRepository() =
        favoriteMovieEntityDataFactory.createApiMoviesEntityData(SourceType.PERSISTENCE)

    override fun getFavoriteMovies(): Observable<List<FavoriteMovie>> {
        return getFavoriteMoviesFromLocal()
            .flatMap { it.mapListToDomain() }
    }

    override fun insertFavoriteMovie(movie: FavoriteMovie): Observable<Unit> {
        return Observable.just(getLocalRepository().insertFavoriteMovie(movie))
    }

    override fun deleteFavoriteMovie(movie: FavoriteMovie): Observable<Unit> {
        return Observable.just(getLocalRepository().insertFavoriteMovie(movie))
    }

    override fun isFavoriteMovie(id: String): Observable<Boolean> {
        return getLocalRepository().isFavoriteMovie(id)
    }

    private fun getFavoriteMoviesFromLocal(): Observable<List<FavoriteMovieEntity>> {
        return getLocalRepository().getFavoriteMovies()
    }

    private fun List<FavoriteMovieEntity>.mapListToDomain() =
        Observable.fromIterable(this)
            .map { it.toDomain() }
            .toList()
            .toObservable()
}