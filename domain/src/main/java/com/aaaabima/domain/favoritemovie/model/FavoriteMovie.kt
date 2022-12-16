/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.domain.favoritemovie.model

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version FavoriteMovie, v 0.1 12/14/2022 5:48 PM by Abim (Moch Arya Bima A)
 */
data class FavoriteMovie(
    val id: Int,
    val original_title: String,
    val overview: String,
    val poster_path: String,
    val genres: String,
    val release_date: String,
    val popularity: Number,
    val runtime: Int,
)