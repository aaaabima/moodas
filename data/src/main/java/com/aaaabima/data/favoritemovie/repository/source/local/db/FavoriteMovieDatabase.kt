/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.data.favoritemovie.repository.source.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aaaabima.data.favoritemovie.model.FavoriteMovieEntity
import com.aaaabima.data.favoritemovie.repository.source.local.dao.FavoriteMovieEntityDao

/**
 * @author Abim (Moch Arya Bima A (i-arya.agfian@dana.id)
 * @version MovieDatabase, v 0.1 12/14/2022 2:10 PM by Abim (Moch Arya Bima A
 */
@Database(entities = [FavoriteMovieEntity::class], version = 1, exportSchema = false)
abstract class FavoriteMovieDatabase : RoomDatabase() {

    abstract fun listMovieDao(): FavoriteMovieEntityDao
    
}