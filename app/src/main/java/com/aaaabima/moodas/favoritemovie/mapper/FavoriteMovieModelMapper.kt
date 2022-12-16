/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.moodas.favoritemovie.mapper

import com.aaaabima.domain.favoritemovie.model.FavoriteMovie
import com.aaaabima.moodas.favoritemovie.model.FavoriteMovieModel

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version FavoriteMovieModelMapper, v 0.1 12/14/2022 10:57 PM by Abim (Moch Arya Bima A)
 */
fun FavoriteMovie.toModel() = FavoriteMovieModel(
    id = id,
    original_title = original_title,
    overview = overview,
    poster_path = poster_path,
    genres = genres,
    release_date = release_date,
    popularity = popularity,
    runtime = runtime
)

fun FavoriteMovieModel.toDomain() = FavoriteMovie(
    id = id,
    original_title = original_title,
    overview = overview,
    poster_path = poster_path,
    genres = genres,
    release_date = release_date,
    popularity = popularity,
    runtime = runtime
)