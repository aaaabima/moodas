/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.moodas.getmovies

import android.os.Bundle
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import com.aaaabima.moodas.BuildConfig
import com.aaaabima.moodas.R
import com.aaaabima.moodas.base.BaseBindingActivity
import com.aaaabima.moodas.base.BaseRecyclerAdapter
import com.aaaabima.moodas.databinding.ActivityGetMoviesBinding
import com.aaaabima.moodas.di.component.DaggerGetMoviesComponent
import com.aaaabima.moodas.di.module.GetMoviesModule
import com.aaaabima.moodas.getmovies.adapter.GetMoviesAdapter
import com.aaaabima.moodas.getmovies.model.MovieModel
import com.aaaabima.moodas.moviedetail.MovieDetailActivity
import com.aaaabima.moodas.util.CustomRvMargin
import com.aaaabima.moodas.util.toast
import timber.log.Timber
import javax.inject.Inject

class GetMoviesActivity : BaseBindingActivity<ActivityGetMoviesBinding>() {
    @Inject
    lateinit var rvAdapter: GetMoviesAdapter

    @Inject
    lateinit var presenter: GetMoviesPresenter

    override fun contentView(): Int = R.layout.activity_get_movies

    override fun setupData(savedInstanceState: Bundle?) {}

    override fun getViewBinding(): ActivityGetMoviesBinding { return ActivityGetMoviesBinding.inflate(layoutInflater) }

    override fun setupView() {
        getViewBinding()
        initInjector()
        initRecyclerView()
        performGetMovies(refresh = true)
    }

    private fun initInjector() {
        DaggerGetMoviesComponent.builder()
            .applicationComponent(getApplicationComponent())
            .getMoviesModule(getGetMoviesModule())
            .build()
            .inject(this)
    }

    private fun getGetMoviesModule() = GetMoviesModule(object: GetMoviesContract.View {
        override fun setMovieResult(movies: List<MovieModel>) {
            if (movies.isEmpty()) {
                binding.tvNoMovie.isVisible = true
                binding.rvItemMovie.isVisible = false
            } else {
                binding.tvNoMovie.isVisible = false
                binding.rvItemMovie.isVisible = true
                rvAdapter.clearAndNotify()
                Timber.d("RESUlT: $movies")
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

    private fun initRecyclerView() {
        binding.rvItemMovie.apply {
            layoutManager = GridLayoutManager(this@GetMoviesActivity, 2)
            adapter = rvAdapter.apply {
                setOnItemClickListener(provideOnItemClickListener())
            }
            addItemDecoration(provideCustomMargin())
        }
    }

    private fun provideOnItemClickListener() =
        object : BaseRecyclerAdapter.AdapterOnClick {
            override fun onRecyclerItemClicked(extra: String) {
                toast("Clicked with extra $extra")
                startActivity(
                    MovieDetailActivity.createIntent(
                        this@GetMoviesActivity,
                        extra.toInt()
                    )
                )
            }
        }

    private fun provideCustomMargin() =
        CustomRvMargin(
            this@GetMoviesActivity,
            8,
            CustomRvMargin.GRID_1
        )

    private fun performGetMovies(refresh: Boolean) {
        presenter.getNowPlayingMovies(BuildConfig.API_KEY, refresh)
    }

    override fun onDestroy() {
        presenter.destroy()
        super.onDestroy()
    }
}