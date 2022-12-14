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
class FavoriteMovieEntity (

    @field:ColumnInfo(name = "id")
    @PrimaryKey
    var id: Int?,

    @field:ColumnInfo(name = "original_title")
    var original_title: String?,

    @field:ColumnInfo(name = "overview")
    var overview: String?,

    @field:ColumnInfo(name = "poster_path")
    var poster_path: String?,

    @field:ColumnInfo(name = "genres")
    val genres: List<String>?,

    @field:ColumnInfo(name = "release_date")
    val release_date: String?,

    @field:ColumnInfo(name = "popularity")
    val popularity: Number?,

    @field:ColumnInfo(name = "runtime")
    val runtime: Int?,
    )