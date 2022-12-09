/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.moodas.getmovies.mapper

import com.aaaabima.domain.apimovies.model.Movie
import com.aaaabima.moodas.getmovies.model.MovieModel

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version UserModelMapper, v 0.1 07/12/22 13.50 by Abim (Moch Arya Bima A)
 */
fun Movie.toModel() = MovieModel(
    id = id,
    original_title = original_title,
    overview = overview,
    poster_path = poster_path,
    genres = genres,
    release_date = release_date,
    popularity = popularity,
    runtime = runtime
)

fun MovieModel.toDomain() = Movie(
    id = id,
    original_title = original_title,
    overview = overview,
    poster_path = poster_path,
    genres = genres,
    release_date = release_date,
    popularity = popularity,
    runtime = runtime
)