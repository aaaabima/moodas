/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.data.network

import com.aaaabima.data.apimovies.repository.source.network.response.MovieDetailResponse
import com.aaaabima.data.apimovies.repository.source.network.response.MovieNowPlayingResponse
import com.aaaabima.data.apimovies.repository.source.network.response.MovieRatedResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version MovieAPI, v 0.1 01/12/22 13.10 by Abim (Moch Arya Bima A)
 */
interface MovieAPI {

    @GET(Constant.Network.Get.NowPlaying)
    fun getNowPlayingMovies(
        @Query("api_key") apiKey: String
    ): Observable<MovieNowPlayingResponse>

    @GET(Constant.Network.Get.Popular)
    fun getPopularMovies(
        @Query("api_key") apiKey: String
    ): Observable<MovieRatedResponse>

    @GET(Constant.Network.Get.TopRated)
    fun getTopRatedMovies(
        @Query("api_key") apiKey: String
    ): Observable<MovieRatedResponse>

    @GET(Constant.Network.Movie.Detail)
    fun getMovieDetail(
        @Query("api_key") apiKey: String,
        @Path("param") id: Int,
    ): Observable<MovieDetailResponse>
}