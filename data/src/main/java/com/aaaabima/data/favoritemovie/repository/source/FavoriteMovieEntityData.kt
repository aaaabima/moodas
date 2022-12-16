/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.data.favoritemovie.repository.source

import com.aaaabima.data.favoritemovie.model.FavoriteMovieEntity
import com.aaaabima.domain.favoritemovie.model.FavoriteMovie
import io.reactivex.Observable

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version FavoriteMoviesEntityData, v 0.1 12/14/2022 5:39 PM by Abim (Moch Arya Bima A)
 */
interface FavoriteMovieEntityData {

    fun getFavoriteMovies(): Observable<List<FavoriteMovieEntity>>

    fun insertFavoriteMovie(movie: FavoriteMovie): Observable<Int>

    fun deleteFavoriteMovie(movie: FavoriteMovie): Observable<Int>

    fun isFavoriteMovie(id: String): Observable<Boolean>
}