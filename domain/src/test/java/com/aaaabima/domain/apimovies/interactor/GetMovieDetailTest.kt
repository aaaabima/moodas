/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.domain.apimovies.interactor

import com.aaaabima.domain.BuildConfig
import com.aaaabima.domain.apimovies.model.GetMovieDetailRequest
import com.aaaabima.domain.apimovies.model.GetNowPlayingMoviesRequest
import com.aaaabima.domain.apimovies.model.Movie
import com.aaaabima.domain.apimovies.repository.ApiMoviesRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.reactivex.Observable
import org.junit.After
import org.junit.Test

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version GetNowPlayingMoviesTest, v 0.1 2022/12/21 12:37 by Abim (Moch Arya Bima A)
 */
class GetMovieDetailTest {

    private var apiMoviesRepository = mockk<ApiMoviesRepository>(relaxed = true)
    private var getMovieDetail = GetMovieDetail(apiMoviesRepository)

    @Test
    fun `buildUseCase should invoke apiMoviesRepository#getNowPlayingMovies`() {
        val requestInfo = GetMovieDetail.Params.createGetMovieDetailRequest(
            GetMovieDetailRequest("19995", BuildConfig.API_KEY)
        )
        val getMovieDetailResult = mockGetMovieDetailResult()
        //given
        every { apiMoviesRepository.getMovieDetail(any(), any()) } returns Observable.just(
            getMovieDetailResult
        )
        //when
        getMovieDetail.buildUseCase(requestInfo)
        //then
        verify { apiMoviesRepository.getMovieDetail(any(),any()) }
    }

    @After
    fun tearDown() {
        getMovieDetail.dispose()
    }

    private fun mockGetMovieDetailResult() =
        Movie(
            "19995",
            "Avatar",
            "In the 22nd century, a paraplegic Marine is dispatched to the moon Pandora on a unique mission, but becomes torn between following orders and protecting an alien civilization.",
            "/jRXYjXNq0Cs2TcJjLkki24MLp7u.jpg",
            arrayListOf("Action", "Adventure", "Fantasy", "Science Fiction"),
            "2009-12-15",
            3086.55,
            162
        )
}