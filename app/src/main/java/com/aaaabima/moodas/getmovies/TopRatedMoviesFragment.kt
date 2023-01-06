/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2023 All Rights Reserved.
 */

package com.aaaabima.moodas.getmovies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import com.aaaabima.moodas.base.BaseBindingFragment
import com.aaaabima.moodas.base.BaseRecyclerAdapter
import com.aaaabima.moodas.databinding.FragmentNowPlayingMoviesBinding
import com.aaaabima.moodas.databinding.FragmentTopRatedBinding
import com.aaaabima.moodas.di.component.DaggerNowPlayingMoviesComponent
import com.aaaabima.moodas.di.component.DaggerTopRatedMoviesComponent
import com.aaaabima.moodas.di.module.NowPlayingMoviesModule
import com.aaaabima.moodas.di.module.TopRatedMoviesModule
import com.aaaabima.moodas.getmovies.adapter.GetMoviesAdapter
import com.aaaabima.moodas.getmovies.model.MovieModel
import com.aaaabima.moodas.moviedetail.MovieDetailActivity
import com.aaaabima.moodas.util.CustomRvMargin
import timber.log.Timber
import javax.inject.Inject

class TopRatedMoviesFragment : BaseBindingFragment<FragmentTopRatedBinding>() {

    @Inject
    lateinit var rvAdapter: GetMoviesAdapter

    @Inject
    lateinit var presenter: TopRatedMoviesPresenter

    override fun setupView() {
        initInjector()
        initRecyclerView()
        performGetMovies()
    }

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentTopRatedBinding {
        return FragmentTopRatedBinding.inflate(inflater, container, false)
    }

    private fun initInjector() {
        DaggerTopRatedMoviesComponent.builder()
            .applicationComponent(getApplicationComponent())
            .topRatedMoviesModule(getTopRatedMoviesModule())
            .build()
            .inject(this)

    }

    private fun initRecyclerView() {
        binding.rvItemMovie.apply {
            layoutManager = GridLayoutManager(this@TopRatedMoviesFragment.context, 2)
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
                        requireContext(),
                        extra.toInt()
                    )
                )
            }
        }

    private fun provideCustomMargin() =
        CustomRvMargin(
            requireContext(),
            8,
            CustomRvMargin.GRID_1
        )

    private fun performGetMovies() {
        presenter.getTopRatedMovies()
    }

    private fun getTopRatedMoviesModule() =
        TopRatedMoviesModule(object : TopRatedMoviesContract.View {
            override fun setMovieResult(movies: List<MovieModel>) {
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

    override fun onDestroy() {
        presenter.destroy()
        super.onDestroy()
    }

    companion object {

        fun newInstance(): TopRatedMoviesFragment = TopRatedMoviesFragment()
    }
}