/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.moodas.getmovies

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import com.aaaabima.moodas.BuildConfig
import com.aaaabima.moodas.R
import com.aaaabima.moodas.base.BaseBindingActivity
import com.aaaabima.moodas.base.BaseRecyclerAdapter
import com.aaaabima.moodas.databinding.ActivityGetMoviesBinding
import com.aaaabima.moodas.di.component.DaggerGetMoviesComponent
import com.aaaabima.moodas.di.module.GetMoviesModule
import com.aaaabima.moodas.favoritemovie.FavoriteMovieActivity
import com.aaaabima.moodas.getmovies.adapter.GetMoviesAdapter
import com.aaaabima.moodas.getmovies.adapter.GetMoviesPagerAdapter
import com.aaaabima.moodas.getmovies.model.MovieModel
import com.aaaabima.moodas.moviedetail.MovieDetailActivity
import com.aaaabima.moodas.util.CustomRvMargin
import com.google.android.material.tabs.TabLayoutMediator
import timber.log.Timber
import javax.inject.Inject

class GetMoviesActivity : BaseBindingActivity<ActivityGetMoviesBinding>() {

    @Inject
    lateinit var presenter: GetMoviesPresenter

    override fun setupData(savedInstanceState: Bundle?) {}

    override fun getViewBinding(): ActivityGetMoviesBinding {
        return ActivityGetMoviesBinding.inflate(layoutInflater)
    }

    override fun setupView() {
        getViewBinding()
        initInjector()
        setupViewPager()
    }

    private fun setupViewPager() {
        binding.vpMain.adapter = GetMoviesPagerAdapter(supportFragmentManager, lifecycle)
        TabLayoutMediator(binding.tabLayoutMain, binding.vpMain) { tab, position ->
            tab.text = GetMoviesPagerAdapter.providePageNames()[position]
        }.attach()
    }

    private fun initInjector() {
        DaggerGetMoviesComponent.builder()
            .applicationComponent(getApplicationComponent())
            .getMoviesModule(getGetMoviesModule())
            .build()
            .inject(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.get_movies_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.favorite -> {
                val intent = Intent(this@GetMoviesActivity, FavoriteMovieActivity::class.java)
                startActivity(intent)
                true
            }

            else -> true
        }
    }

    private fun getGetMoviesModule() = GetMoviesModule(object : GetMoviesContract.View {

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
}