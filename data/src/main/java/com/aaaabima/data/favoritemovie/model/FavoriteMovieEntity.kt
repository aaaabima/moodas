/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.data.favoritemovie.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.aaaabima.data.network.Constant

/**
 * @author Abim (Moch Arya Bima A (i-arya.agfian@dana.id)
 * @version FavoriteMovieEntity, v 0.1 12/14/2022 3:05 PM by Abim (Moch Arya Bima A
 */
@Entity(tableName = Constant.Database.Table.MOVIE)
data class FavoriteMovieEntity (

    @ColumnInfo(name = "id")
    @PrimaryKey
    var id: Int?,

    @ColumnInfo(defaultValue = "")
    var original_title: String?,

    @ColumnInfo(defaultValue = "")
    var overview: String?,

    @ColumnInfo(defaultValue = "")
    var poster_path: String?,

    @ColumnInfo(defaultValue = "")
    val genres: String?,

    @ColumnInfo(defaultValue = "")
    val release_date: String?,

    @ColumnInfo(defaultValue = "0")
    val popularity: Float?,

    @ColumnInfo(defaultValue = "0")
    val runtime: Int?,
    )