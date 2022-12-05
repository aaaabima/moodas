/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.data.apimovies.model

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version MovieEntity, v 0.1 05/12/22 07.55 by Abim (Moch Arya Bima A)
 */
data class MovieEntity(
    val id: Int?,
    val original_title: String?,
    val overview: String?,
    val poster_path: String?,
    val genres: List<Int>?,
    val release_date: String?,
    val popularity: Int?,
    val runtime: Int?,
    )
