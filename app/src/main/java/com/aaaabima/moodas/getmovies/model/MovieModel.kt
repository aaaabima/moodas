/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.moodas.getmovies.model

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version MovieModel, v 0.1 07/12/22 10.57 by Abim (Moch Arya Bima A)
 */
data class MovieModel(
    val id: String,
    val original_title: String,
    val overview: String,
    val poster_path: String,
    val genres: List<String>,
    val release_date: String,
    val popularity: Number,
    val runtime: Int,
)
