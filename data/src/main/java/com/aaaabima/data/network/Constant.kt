/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.data.network

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version Constant, v 0.1 01/12/22 13.14 by Abim (Moch Arya Bima A)
 */
object Constant {

    object Database {

        const val DATABASE_NAME = "Movie_DATABASE"

        object Table {

            const val MOVIE = "movie_entity"
        }
    }

    object Network {
        object Get {

            private const val PREFIX = "movie"
            const val NowPlaying = "$PREFIX/now_playing"
            const val TopRated = "$PREFIX/top_rated"
            const val Popular = "$PREFIX/popular"
        }

        object Movie {

            private const val PREFIX = "movie"
            const val Detail = "$PREFIX/{param}"
            const val Videos = "$PREFIX/{param}/videos"
        }
    }
}