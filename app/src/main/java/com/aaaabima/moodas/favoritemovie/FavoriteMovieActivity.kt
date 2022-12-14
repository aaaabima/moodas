/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.moodas.favoritemovie
import com.aaaabima.moodas.R
import com.aaaabima.moodas.base.BaseBindingActivity
import android.os.Bundle
import com.aaaabima.moodas.databinding.ActivityFavoriteMovieBinding
import com.aaaabima.moodas.di.component.DaggerFavoriteMovieComponent
import com.aaaabima.moodas.di.module.FavoriteMovieModule
import com.aaaabima.moodas.favoritemovie.model.FavoriteMovieModel
import javax.inject.Inject

class FavoriteMovieActivity : BaseBindingActivity<ActivityFavoriteMovieBinding>() {

    @Inject
    lateinit var presenter: FavoriteMoviePresenter

    override fun contentView(): Int = R.layout.activity_favorite_movie

    override fun setupData(savedInstanceState: Bundle?) {}

    override fun setupView() {
        getViewBinding()
        initInjector()
    }

    override fun getViewBinding(): ActivityFavoriteMovieBinding {
        return ActivityFavoriteMovieBinding.inflate(layoutInflater)
    }

    private fun initInjector() {
        DaggerFavoriteMovieComponent.builder()
            .applicationComponent(getApplicationComponent())
            .favoriteMovieModule(getFavoriteMovieModule())
            .build()
            .inject(this)
    }

    private fun getFavoriteMovieModule() = FavoriteMovieModule(object: FavoriteMovieContract.View {
        override fun setFavoriteMovieResult(movies: List<FavoriteMovieModel>) {
            TODO("Not yet implemented")
        }

        override fun showProgress() {
            TODO("Not yet implemented")
        }

        override fun dismissProgress() {
            TODO("Not yet implemented")
        }

        override fun onError(errorMessage: String?) {
            TODO("Not yet implemented")
        }

        })
}