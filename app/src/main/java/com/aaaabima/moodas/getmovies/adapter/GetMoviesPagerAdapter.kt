/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2023 All Rights Reserved.
 */

package com.aaaabima.moodas.getmovies.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.aaaabima.moodas.getmovies.NowPlayingMoviesFragment
import com.aaaabima.moodas.getmovies.PopularMoviesFragment
import com.aaaabima.moodas.getmovies.TopRatedMoviesFragment

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version GetMoviesPagerAdapter, v 0.1 06/01/23 11.02 by Abim (Moch Arya Bima A)
 */
class GetMoviesPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int = PAGE_COUNT

    override fun createFragment(position: Int): Fragment =
        when(position) {
            0 -> NowPlayingMoviesFragment.newInstance()
            1 -> PopularMoviesFragment()
            2 -> TopRatedMoviesFragment()
            else -> NowPlayingMoviesFragment.newInstance()
        }

    companion object {
        private  const val PAGE_COUNT = 3

        fun providePageNames() = arrayListOf("Now Playing", "Popular", "Top Rated")
    }
}