/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.moodas.favoritemovie.model

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version FavoriteMovieModel, v 0.1 12/14/2022 10:56 PM by Abim (Moch Arya Bima A)
 */
data class FavoriteMovieModel(
    val id: Int,
    val original_title: String,
    val overview: String,
    val poster_path: String,
    val genres: String,
    val release_date: String,
    val popularity: Number,
    val runtime: Int,
)