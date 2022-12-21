/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.moodas.moviedetail.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.aaaabima.moodas.R
import com.aaaabima.moodas.base.BaseRecyclerAdapter
import com.aaaabima.moodas.databinding.ItemTrailerBinding
import com.aaaabima.moodas.moviedetail.model.MovieTrailerModel
import javax.inject.Inject

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version MovieTrailerAdapter, v 0.1 19/12/22 13.49 by Abim (Moch Arya Bima A)
 */
class MovieTrailerAdapter @Inject constructor(
    context: Context
) : BaseRecyclerAdapter<MovieTrailerModel, MovieTrailerAdapter.ViewHolder>(context) {

    override fun getResLayout(type: Int): Int = R.layout.item_trailer

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemTrailerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    inner class ViewHolder(var binding: ItemTrailerBinding) : BaseViewHolder(binding) {

        override fun onBind(model: MovieTrailerModel) {
            if (model.type == "Trailer") {
                binding.tvTrailer.apply {
                    text = model.name
                    setOnClickListener {
                        getCallback()?.onRecyclerItemClicked(model.key)
                    }
                }
            }
        }
    }
}