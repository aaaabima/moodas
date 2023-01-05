/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.moodas.moviedetail

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.aaaabima.moodas.R
import com.aaaabima.moodas.base.BaseBindingActivity
import com.aaaabima.moodas.base.BaseRecyclerAdapter
import com.aaaabima.moodas.databinding.ActivityMovieDetailBinding
import com.aaaabima.moodas.di.component.DaggerMovieDetailComponent
import com.aaaabima.moodas.di.module.MovieDetailModule
import com.aaaabima.moodas.getmovies.mapper.toFavoriteMovieModel
import com.aaaabima.moodas.getmovies.model.MovieModel
import com.aaaabima.moodas.moviedetail.adapter.MovieTrailerAdapter
import com.aaaabima.moodas.moviedetail.model.MovieTrailerModel
import com.aaaabima.moodas.util.CustomRvMargin
import com.aaaabima.moodas.util.toast
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

    private val isFavorited = MutableLiveData<Boolean>()

    @Inject
    lateinit var rvAdapter: MovieTrailerAdapter

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
        initRecyclerView()
        id.let {
            presenter.getMovieDetail(it)
            presenter.getMovieTrailer(it)
        }
    }

    private fun initRecyclerView() {
        binding.rvItemTrailer.apply {
            layoutManager = LinearLayoutManager(this@MovieDetailActivity)
            adapter = rvAdapter.apply {
                setOnItemClickListener(provideOnItemClickListener())
            }
            addItemDecoration(provideCustomMargin())
        }
    }

    private fun initInjector() {
        DaggerMovieDetailComponent.builder()
            .applicationComponent(getApplicationComponent())
            .movieDetailModule(getMovieDetailModule())
            .build()
            .inject(this)
    }

    private fun provideOnItemClickListener() =
        object : BaseRecyclerAdapter.AdapterOnClick {
            override fun onRecyclerItemClicked(extra: String) {
                val uri = Uri.parse("https://www.youtube.com/watch?v=$extra")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
            }
        }

    private fun provideCustomMargin() =
        CustomRvMargin(
            this@MovieDetailActivity,
            8,
            CustomRvMargin.LINEAR_VERTICAL
        )

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
                    presenter.isFavoriteMovie(it.id)
                    isFavorited.observe(this@MovieDetailActivity) { favorite ->
                        if (favorite) {
                            Glide.with(this@MovieDetailActivity)
                                .load(R.drawable.ic_baseline_favorite_50)
                                .into(binding.ivFavorite)
                            binding.ivFavorite.setOnClickListener {
                                presenter.deleteFavoriteMovie(
                                    movie.toFavoriteMovieModel()
                                )
                                toast("Change to Unfavorite")
                                isFavorited.value = false
                            }
                        } else if (!favorite) {
                            Glide.with(this@MovieDetailActivity)
                                .load(R.drawable.ic_twotone_unfavorite_50)
                                .into(binding.ivFavorite)
                            binding.ivFavorite.setOnClickListener {
                                presenter.insertFavoriteMovie(
                                    movie.toFavoriteMovieModel()
                                )
                                toast("Change to Favorite")
                                isFavorited.value = true
                            }
                        }
                    }
                }
            }
        }

        override fun setMovieTrailerResult(trailer: List<MovieTrailerModel>) {
            if (trailer.isEmpty()) {
                binding.rvItemTrailer.isVisible = false
                binding.tvNoTrailer.isVisible = true
            } else {
                binding.tvNoTrailer.isVisible = false
                binding.rvItemTrailer.isVisible = true
                rvAdapter.clearAndNotify()
                rvAdapter.insertAndNotify(filterTrailer(trailer))
            }
        }

        private fun filterTrailer(trailerModel: List<MovieTrailerModel>): List<MovieTrailerModel> {
            val trailerVideo = mutableListOf<MovieTrailerModel>()
            trailerModel.map { it ->
                if (it.type == "Trailer")
                    trailerVideo.add(it)
            }
            return trailerVideo
        }

        override fun setFavoriteState(isFavorite: Boolean) {
            isFavorited.value = isFavorite
        }

        override fun showProgress() {
            binding.pbFavorite.visibility = View.VISIBLE
        }

        override fun dismissProgress() {
            binding.pbFavorite.visibility = View.GONE
        }

        override fun onError(errorMessage: String?) {
            Timber.e(errorMessage)
        }

    })
}