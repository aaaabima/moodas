/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.data.favoritemovie.repository.source.local

import com.aaaabima.data.favoritemovie.mapper.toEntity
import com.aaaabima.data.favoritemovie.model.FavoriteMovieEntity
import com.aaaabima.data.favoritemovie.repository.source.FavoriteMovieEntityData
import com.aaaabima.data.favoritemovie.repository.source.local.dao.FavoriteMovieEntityDao
import com.aaaabima.domain.favoritemovie.model.FavoriteMovie
import io.reactivex.Observable
import javax.inject.Inject

/**
 * @author Abim (Moch Arya Bima A (i-arya.agfian@dana.id)
 * @version PersistenceApiMoviesEntityData, v 0.1 12/14/2022 2:08 PM by Abim (Moch Arya Bima A
 */
class PersistenceFavoriteMovieEntityData @Inject constructor(
    private val favoriteMovieEntityDao: FavoriteMovieEntityDao,
) : FavoriteMovieEntityData {

    override fun getFavoriteMovies(): Observable<List<FavoriteMovieEntity>> {
        return favoriteMovieEntityDao.getFavoriteMovies()
    }

    override fun insertFavoriteMovie(movie: FavoriteMovie): Observable<Int> {
        favoriteMovieEntityDao.insertFavoriteMovie(movie.toEntity())
        return Observable.just(1)
    }

    override fun deleteFavoriteMovie(movie: FavoriteMovie): Observable<Int> {
        favoriteMovieEntityDao.deleteFavoriteMovie(movie.toEntity())
        return Observable.just(1)
    }

    override fun isFavoriteMovie(id: String): Observable<Boolean> {
        return favoriteMovieEntityDao.isFavoriteMovie(id)
    }
}