/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.moodas.moviedetail.model

import java.util.*

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version MovieTrailerModel, v 0.1 19/12/22 11.37 by Abim (Moch Arya Bima A)
 */
data class MovieTrailerModel (
    val id: String,
    val name: String,
    val key: String,
    val type: String,
    val published_at: Date,
    val site: String
)