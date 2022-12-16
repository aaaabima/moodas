/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.moodas.getmovies.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.aaaabima.moodas.R
import com.aaaabima.moodas.base.BaseRecyclerAdapter
import com.aaaabima.moodas.databinding.ItemMovieBinding
import com.aaaabima.moodas.getmovies.model.MovieModel
import com.bumptech.glide.Glide
import javax.inject.Inject

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version GetMoviesAdapter, v 0.1 07/12/22 14.10 by Abim (Moch Arya Bima A)
 */
class GetMoviesAdapter @Inject constructor(
    context: Context
) : BaseRecyclerAdapter<MovieModel, GetMoviesAdapter.ViewHolder>(context) {

    override fun getResLayout(type: Int): Int = R.layout.item_movie

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    inner class ViewHolder(var binding: ItemMovieBinding) : BaseViewHolder(binding) {

        override fun onBind(model: MovieModel) {
            val imageUrl = "https://image.tmdb.org/t/p/original${model.poster_path}"
            Glide.with(context!!).load(imageUrl).into(binding.ivPoster)
            binding.tvTitle.text = model.original_title
            binding.cvItemMovie.setOnClickListener {
                getCallback()?.onRecyclerItemClicked(model.id.toString())
            }
        }
    }
}