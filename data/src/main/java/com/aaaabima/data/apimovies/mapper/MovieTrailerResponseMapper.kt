/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.data.apimovies.mapper

import com.aaaabima.data.apimovies.model.MovieEntity
import com.aaaabima.data.apimovies.model.MovieTrailerEntity
import com.aaaabima.data.apimovies.repository.source.network.response.MovieTrailerItem
import com.aaaabima.data.apimovies.repository.source.network.response.MovieTrailerResponse
import com.aaaabima.domain.apimovies.model.Movie
import com.aaaabima.domain.apimovies.model.MovieTrailer

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version MovieTrailerResponseMapper, v 0.1 2022/12/16 17:45 by Abim (Moch Arya Bima A)
 */
fun MovieTrailerItem.toDomain(): MovieTrailer {
    return MovieTrailer(
        this.id!!,
        this.name.orEmpty(),
        this.key.orEmpty(),
        this.type.orEmpty(),
        this.publishedAt!!,
        this.site.orEmpty(),
    )
}

fun MovieTrailerItem.toEntity(): MovieTrailerEntity {
    return MovieTrailerEntity(
        this.id,
        this.name,
        this.key,
        this.type,
        this.publishedAt,
        this.site,
    )
}

internal fun MovieTrailerEntity.toDomain(): MovieTrailer {
    return MovieTrailer(
        this.id!!,
        this.name.orEmpty(),
        this.key.orEmpty(),
        this.type.orEmpty(),
        this.published_at!!,
        this.site.orEmpty(),
    )
}