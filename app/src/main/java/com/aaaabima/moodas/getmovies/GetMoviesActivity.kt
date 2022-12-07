/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.moodas.getmovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aaaabima.moodas.databinding.ActivityGetMoviesBinding

class GetMoviesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGetMoviesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGetMoviesBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}