/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.moodas.favoritemovie.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.aaaabima.moodas.R
import com.aaaabima.moodas.base.BaseRecyclerAdapter
import com.aaaabima.moodas.databinding.ItemMovieBinding
import com.aaaabima.moodas.favoritemovie.model.FavoriteMovieModel
import com.bumptech.glide.Glide
import javax.inject.Inject

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version FavoriteMovieAdapter, v 0.1 12/14/2022 10:57 PM by Abim (Moch Arya Bima A)
 */
class FavoriteMovieAdapter @Inject constructor(
    context: Context
) : BaseRecyclerAdapter<FavoriteMovieModel, FavoriteMovieAdapter.ViewHolder>(context) {

    override fun getResLayout(type: Int): Int = R.layout.item_movie

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    inner class ViewHolder(var binding: ItemMovieBinding) : BaseViewHolder(binding) {

        override fun onBind(model: FavoriteMovieModel) {
            val imageUrl = "https://image.tmdb.org/t/p/original${model.poster_path}"
            Glide.with(context!!).load(imageUrl).into(binding.ivPoster)
            binding.tvTitle.text = model.original_title
            binding.cvItemMovie.setOnClickListener {
                getCallback()?.onRecyclerItemClicked(model.id.toString())
            }
        }
    }
}