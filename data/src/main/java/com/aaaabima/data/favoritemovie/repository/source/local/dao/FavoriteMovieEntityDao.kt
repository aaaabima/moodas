/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.data.favoritemovie.repository.source.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aaaabima.data.apimovies.model.MovieEntity
import com.aaaabima.data.favoritemovie.model.FavoriteMovieEntity
import com.aaaabima.data.network.Constant
import io.reactivex.Observable

/**
 * @author Abim (Moch Arya Bima A (i-arya.agfian@dana.id)
 * @version MovieEntityDao, v 0.1 12/14/2022 2:12 PM by Abim (Moch Arya Bima A)
 */
@Dao
interface FavoriteMovieEntityDao {

    @Query("SELECT * FROM ${Constant.Database.Table.MOVIE}")
    fun getFavoriteMovies(): Observable<List<FavoriteMovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavoriteMovie(movie: MovieEntity)

    @Delete
    fun deleteFavoriteMovie(movie: MovieEntity)

    @Query("SELECT EXISTS(SELECT * FROM ${Constant.Database.Table.MOVIE} WHERE id = :id)")
    fun isFavoriteMovie(id: String): Boolean
}