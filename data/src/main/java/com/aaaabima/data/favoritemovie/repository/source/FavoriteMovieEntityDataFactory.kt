/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.data.favoritemovie.repository.source

import com.aaaabima.data.favoritemovie.repository.source.local.PersistenceFavoriteMovieEntityData
import com.aaaabima.data.util.SourceType
import javax.inject.Inject

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version FavoriteMoviesEntityDataFactory, v 0.1 12/14/2022 5:39 PM by Abim (Moch Arya Bima A)
 */
class FavoriteMovieEntityDataFactory @Inject constructor(
    private val persistenceFavoriteMovieEntityData: PersistenceFavoriteMovieEntityData
) {

    fun createApiMoviesEntityData(sourceType: SourceType): FavoriteMovieEntityData =
        persistenceFavoriteMovieEntityData
}