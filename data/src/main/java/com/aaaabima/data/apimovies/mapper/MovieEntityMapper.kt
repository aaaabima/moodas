/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.data.apimovies.mapper

import com.aaaabima.data.apimovies.model.MovieEntity
import com.aaaabima.domain.apimovies.model.Movie

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version MovieEntityMapper, v 0.1 06/12/22 13.25 by Abim (Moch Arya Bima A)
 */
fun Movie.toEntity(): MovieEntity {
    return MovieEntity(
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

internal fun MovieEntity.toDomain(): Movie {
    return Movie(
        this.id!!,
        this.original_title.orEmpty(),
        this.overview.orEmpty(),
        this.poster_path.orEmpty(),
        this.genres.orEmpty(),
        this.release_date.orEmpty(),
        this.popularity ?: 0,
        this.runtime ?: 0
    )
}