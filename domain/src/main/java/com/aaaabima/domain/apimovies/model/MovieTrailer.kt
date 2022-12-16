/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.domain.apimovies.model

import java.util.*

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version MovieTrailer, v 0.1 2022/12/16 17:51 by Abim (Moch Arya Bima A)
 */
data class MovieTrailer (
    val id: String,
    val name: String,
    val key: String,
    val published_at: Date,
    val site: String
    )