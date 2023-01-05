/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2023 All Rights Reserved.
 */

package com.aaaabima.moodas.getmovies

import android.view.LayoutInflater
import android.view.ViewGroup
import com.aaaabima.moodas.base.BaseBindingFragment
import com.aaaabima.moodas.databinding.FragmentNowPlayingMoviesBinding

class NowPlayingMoviesFragment : BaseBindingFragment<FragmentNowPlayingMoviesBinding>() {

    override fun setupView() {
        TODO("Not yet implemented")
    }

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentNowPlayingMoviesBinding {
        return FragmentNowPlayingMoviesBinding.inflate(inflater, container, false)
    }


}