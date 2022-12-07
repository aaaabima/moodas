/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.data.apimovies.mapper

import com.aaaabima.data.apimovies.model.MovieEntity
import com.aaaabima.data.apimovies.repository.source.network.response.MovieDetailResponse
import com.aaaabima.data.apimovies.repository.source.network.response.ResultsItem
import com.aaaabima.domain.apimovies.model.Movie

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version MovieDetailResponseMapper, v 0.1 06/12/22 14.29 by Abim (Moch Arya Bima A)
 */
fun MovieDetailResponse.toDomain(): Movie {
    val genreIds = mutableListOf<String>()
    this.genres?.map { it ->
        genreIds.add(it?.name.orEmpty())
    }

    return Movie(
        this.id,
        this.originalTitle.orEmpty(),
        this.overview.orEmpty(),
        this.posterPath.toString(),
        genreIds,
        this.releaseDate.orEmpty(),
        this.popularity?: 0,
        0
    )
}

fun MovieDetailResponse.toEntity(): MovieEntity {
    val genreIds = mutableListOf<String>()
    this.genres?.map { it ->
        genreIds.add(it?.name.orEmpty())
    }

    return MovieEntity(
        this.id,
        this.originalTitle,
        this.overview,
        this.posterPath,
        genreIds,
        this.releaseDate,
        this.popularity,
        0
    )
}