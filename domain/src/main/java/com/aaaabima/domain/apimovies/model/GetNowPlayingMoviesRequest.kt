/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.domain.apimovies.model

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version GetMoviesRequest, v 0.1 05/12/22 08.33 by Abim (Moch Arya Bima A)
 */
data class GetNowPlayingMoviesRequest(val apiKey: String, val refresh: Boolean)