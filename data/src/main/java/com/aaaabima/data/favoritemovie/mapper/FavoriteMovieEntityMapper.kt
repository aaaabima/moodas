/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.data.favoritemovie.mapper

import com.aaaabima.data.apimovies.mapper.toDomain
import com.aaaabima.data.apimovies.mapper.toEntity
import com.aaaabima.data.apimovies.model.MovieEntity
import com.aaaabima.data.favoritemovie.model.FavoriteMovieEntity
import com.aaaabima.domain.apimovies.model.Movie
import com.aaaabima.domain.favoritemovie.model.FavoriteMovie

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version FavoriteMovieMapper, v 0.1 12/14/2022 5:38 PM by Abim (Moch Arya Bima A)
 */
fun FavoriteMovie.toEntity(): FavoriteMovieEntity {
    return FavoriteMovieEntity(
        this.id,
        this.original_title,
        this.overview,
        this.poster_path,
        this.genres,
        this.release_date,
        this.popularity,
        this.runtime
    )
}

internal fun FavoriteMovieEntity.toDomain(): FavoriteMovie {
    return FavoriteMovie(
        this.id!!,
        this.original_title.orEmpty(),
        this.overview.orEmpty(),
        this.poster_path.orEmpty(),
        this.genres.orEmpty(),
        this.release_date.orEmpty(),
        this.popularity ?: 0,
        this.runtime?: 0
    )
}