/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.moodas.moviedetail

import com.aaaabima.domain.apimovies.interactor.GetMovieDetail
import com.aaaabima.domain.apimovies.model.GetMovieDetailRequest
import com.aaaabima.moodas.getmovies.mapper.toModel
import javax.inject.Inject

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version MovieDetailPresenter, v 0.1 06/12/22 15.38 by Abim (Moch Arya Bima A)
 */
class MovieDetailPresenter @Inject constructor(
    private val view: MovieDetailContract.View,
    private val getMovieDetail: GetMovieDetail
): MovieDetailContract.Presenter {

    override fun getMovieDetail(id: Int, apiKey: String) {
        view.showProgress()
        getMovieDetail.execute(
            GetMovieDetail.Params.createGetMovieDetailRequest(
                GetMovieDetailRequest(id, apiKey)
            ), onSuccess = { movie ->
                view.setMovieResult(movie.toModel())
                view.dismissProgress()
            }, onError = {
                view.onError(it.message)
                view.dismissProgress()
            }
        )
    }

    override fun resume() {
        // no implementation
    }

    override fun pause() {
        // no implementation
    }

    override fun destroy() {
        getMovieDetail.dispose()
    }

}