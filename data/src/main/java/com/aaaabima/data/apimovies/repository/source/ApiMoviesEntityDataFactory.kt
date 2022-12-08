/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.data.apimovies.repository.source

import com.aaaabima.data.apimovies.repository.source.network.NetworkApiMoviesEntityData
import com.aaaabima.data.util.SourceType
import javax.inject.Inject

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version ApiMoviesEntityDataFactory, v 0.1 01/12/22 14.28 by Abim (Moch Arya Bima A)
 */
class ApiMoviesEntityDataFactory @Inject constructor(
    private val networkEntityData: NetworkApiMoviesEntityData
) {

    fun createApiMoviesEntityData(sourceType: SourceType): ApiMoviesEntityData =
        networkEntityData
}