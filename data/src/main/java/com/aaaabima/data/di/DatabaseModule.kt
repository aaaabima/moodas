/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.data.di

import android.content.Context
import androidx.room.Room
import com.aaaabima.data.favoritemovie.repository.source.local.dao.FavoriteMovieEntityDao
import com.aaaabima.data.favoritemovie.repository.source.local.db.FavoriteMovieDatabase
import com.aaaabima.data.network.Constant
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version DatabaseModule, v 0.1 12/14/2022 10:51 PM by Abim (Moch Arya Bima A)
 */
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        context: Context
    ) = Room.databaseBuilder(
        context,
        FavoriteMovieDatabase::class.java,
        Constant.Database.DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideUserDao(
        database: FavoriteMovieDatabase
    ): FavoriteMovieEntityDao =
        database.listMovieDao()
}