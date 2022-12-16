/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.domain.favoritemovie.repository

import com.aaaabima.domain.favoritemovie.model.FavoriteMovie
import io.reactivex.Observable

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version FavoriteMovieRepository, v 0.1 12/14/2022 5:44 PM by Abim (Moch Arya Bima A)
 */
interface FavoriteMovieRepository {
    fun getFavoriteMovies(): Observable<List<FavoriteMovie>>

    fun insertFavoriteMovie(movie: FavoriteMovie): Observable<Int>

    fun deleteFavoriteMovie(movie: FavoriteMovie): Observable<Int>

    fun isFavoriteMovie(id: String): Observable<Boolean>
}