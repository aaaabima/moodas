/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.moodas.favoritemovie

import com.aaaabima.moodas.R
import com.aaaabima.moodas.base.BaseBindingActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import com.aaaabima.moodas.base.BaseRecyclerAdapter
import com.aaaabima.moodas.databinding.ActivityFavoriteMovieBinding
import com.aaaabima.moodas.di.component.DaggerFavoriteMovieComponent
import com.aaaabima.moodas.di.module.FavoriteMovieModule
import com.aaaabima.moodas.favoritemovie.adapter.FavoriteMovieAdapter
import com.aaaabima.moodas.favoritemovie.model.FavoriteMovieModel
import com.aaaabima.moodas.moviedetail.MovieDetailActivity
import com.aaaabima.moodas.util.CustomRvMargin
import timber.log.Timber
import javax.inject.Inject

class FavoriteMovieActivity : BaseBindingActivity<ActivityFavoriteMovieBinding>() {

    @Inject
    lateinit var rvAdapter: FavoriteMovieAdapter

    @Inject
    lateinit var presenter: FavoriteMoviePresenter

    override fun contentView(): Int = R.layout.activity_favorite_movie

    override fun setupData(savedInstanceState: Bundle?) {}

    override fun setupView() {
        getViewBinding()
        initInjector()
        initRecyclerView()
        performGetFavoriteMovies()
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

    private fun initRecyclerView() {
        binding.rvItemMovie.apply {
            layoutManager = GridLayoutManager(this@FavoriteMovieActivity, 2)
            adapter = rvAdapter.apply {
                setOnItemClickListener(provideOnItemClickListener())
            }
            addItemDecoration(provideCustomMargin())
        }
    }

    private fun provideOnItemClickListener() =
        object : BaseRecyclerAdapter.AdapterOnClick {
            override fun onRecyclerItemClicked(extra: String) {
                startActivity(
                    MovieDetailActivity.createIntent(
                        this@FavoriteMovieActivity,
                        extra.toInt()
                    )
                )
            }
        }

    private fun provideCustomMargin() =
        CustomRvMargin(
            this@FavoriteMovieActivity,
            8,
            CustomRvMargin.GRID_1
        )

    private fun performGetFavoriteMovies() {
        presenter.getFavoriteMovies()
    }

    private fun getFavoriteMovieModule() = FavoriteMovieModule(object : FavoriteMovieContract.View {
        override fun setFavoriteMovieResult(movies: List<FavoriteMovieModel>) {
            if (movies.isEmpty()) {
                binding.tvNoMovie.isVisible = true
                binding.rvItemMovie.isVisible = false
            } else {
                binding.tvNoMovie.isVisible = false
                binding.rvItemMovie.isVisible = true
                rvAdapter.clearAndNotify()
                rvAdapter.insertAndNotify(movies)
            }
        }

        override fun showProgress() {
            //
        }

        override fun dismissProgress() {
            //
        }

        override fun onError(errorMessage: String?) {
            Timber.e(errorMessage)
        }

    })
}