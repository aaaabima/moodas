/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.moodas.moviedetail

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aaaabima.moodas.R
import com.aaaabima.moodas.base.BaseBindingActivity
import com.aaaabima.moodas.databinding.ActivityMovieDetailBinding

class MovieDetailActivity : BaseBindingActivity<ActivityMovieDetailBinding>() {
    companion object {
        private const val KEY_INTENT_ID = "[ID]"

        fun createIntent(context: Context, id: String): Intent {
            return Intent(context, MovieDetailActivity::class.java).putExtra(
                KEY_INTENT_ID,
                id
            )
        }
    }

    override fun contentView(): Int {
        TODO("Not yet implemented")
    }

    override fun setupData(savedInstanceState: Bundle?) {
        TODO("Not yet implemented")
    }

    override fun setupView() {
        TODO("Not yet implemented")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
    }

    override fun getViewBinding(): ActivityMovieDetailBinding {
        TODO("Not yet implemented")
    }
}