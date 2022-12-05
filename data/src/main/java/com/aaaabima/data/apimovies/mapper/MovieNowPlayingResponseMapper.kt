/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.data.apimovies.mapper

import com.aaaabima.data.apimovies.model.MovieEntity
import com.aaaabima.data.apimovies.repository.source.network.response.ResultsItem
import com.aaaabima.domain.apimovies.model.Movie

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version MovieNowPlayingResponseMapper, v 0.1 05/12/22 12.10 by Abim (Moch Arya Bima A)
 */
class MovieNowPlayingResponseMapper {

    fun ResultsItem.toDomain(): Movie {
        return Movie(
            this.id,
            this.originalTitle!!,
            this.overview!!,
            this.posterPath!!,
            this.genreIds!!,
            this.releaseDate!!,
            this.popularity!!,
            0
        )
    }

    fun ResultsItem.toEntity(): MovieEntity {
        return MovieEntity(
            this.id,
            this.originalTitle!!,
            this.overview!!,
            this.posterPath!!,
            this.genreIds!!,
            this.releaseDate!!,
            this.popularity!!,
            0
        )
    }
}