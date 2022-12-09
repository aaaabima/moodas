/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.moodas.moviedetail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.aaaabima.moodas.BuildConfig
import com.aaaabima.moodas.R
import com.aaaabima.moodas.base.BaseBindingActivity
import com.aaaabima.moodas.databinding.ActivityMovieDetailBinding
import com.aaaabima.moodas.di.component.DaggerMovieDetailComponent
import com.aaaabima.moodas.di.module.MovieDetailModule
import com.aaaabima.moodas.getmovies.model.MovieModel
import com.bumptech.glide.Glide
import timber.log.Timber
import javax.inject.Inject

class MovieDetailActivity : BaseBindingActivity<ActivityMovieDetailBinding>() {
    companion object {

        private const val KEY_INTENT_ID = "[ID]"

        fun createIntent(context: Context, id: Int): Intent {
            return Intent(context, MovieDetailActivity::class.java).putExtra(
                KEY_INTENT_ID,
                id
            )
        }
    }

    private var id = 0

    @Inject
    lateinit var presenter: MovieDetailPresenter

    override fun getViewBinding(): ActivityMovieDetailBinding {
        return ActivityMovieDetailBinding.inflate(layoutInflater)
    }

    override fun contentView(): Int = R.layout.activity_movie_detail

    override fun setupData(savedInstanceState: Bundle?) {
        intent.getIntExtra(KEY_INTENT_ID, 0).let {
            id = it
        }
    }

    override fun setupView() {
        getViewBinding()
        initInjector()
        id.let {
            presenter.getMovieDetail(it, BuildConfig.API_KEY)
        }
    }

    private fun initInjector() {
        DaggerMovieDetailComponent.builder()
            .applicationComponent(getApplicationComponent())
            .movieDetailModule(getMovieDetailModule())
            .build()
            .inject(this)
    }

    private fun getMovieDetailModule() = MovieDetailModule(object : MovieDetailContract.View {
        override fun setMovieResult(movie: MovieModel) {
            movie.let {
                val imageUrl = "https://image.tmdb.org/t/p/original${it.poster_path}"
                binding.apply {
                    Glide.with(this@MovieDetailActivity)
                        .load(imageUrl)
                        .into(ivPoster)
                    tvTitle.text = presenter.formatDisplayText("Title", it.original_title)
                    tvOverview.text = presenter.formatDisplayText("Overview", it.overview)
                    tvReleaseDate.text =
                        presenter.formatDisplayText("Release Date", it.release_date)
                    tvGenre.text =
                        presenter.formatDisplayText("Genre", presenter.formatGenre(it.genres))
                    tvRuntime.text =
                        presenter.formatDisplayText("Title", presenter.formatRuntime(it.runtime))
                    tvPopularity.text =
                        presenter.formatDisplayText("Popularity", it.popularity.toString())
                }
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