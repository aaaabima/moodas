/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.moodas.getmovies.mapper

import com.aaaabima.domain.apimovies.model.MovieTrailer
import com.aaaabima.moodas.moviedetail.model.MovieTrailerModel

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version MovieTrailerModelMapper, v 0.1 19/12/22 11.38 by Abim (Moch Arya Bima A)
 */
fun MovieTrailer.toModel(): MovieTrailerModel {
    return MovieTrailerModel(
        this.id,
        this.name,
        this.key,
        this.type,
        this.published_at,
        this.site,
    )
}

fun MovieTrailerModel.toDomain(): MovieTrailer {
    return MovieTrailer(
        this.id,
        this.name,
        this.key,
        this.type,
        this.published_at,
        this.site,
    )
}