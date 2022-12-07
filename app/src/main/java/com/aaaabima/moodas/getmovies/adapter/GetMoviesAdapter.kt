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
import com.aaaabima.moodas.getmovies.model.MovieModel
import javax.inject.Inject

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version GetMoviesAdapter, v 0.1 07/12/22 14.10 by Abim (Moch Arya Bima A)
 */
class GetMoviesAdapter @Inject constructor(
    context: Context
): BaseRecyclerAdapter<MovieModel, GetMoviesAdapter.ViewHolder>(context) {
    override fun getResLayout(type: Int): Int = R.layout.item_movie

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    inner class ViewHolder(itemView: ItemMovieBinding) : BaseViewHolder(itemView) {

        override fun onBind(model: MovieModel) {
            view.user = model
//            model.username?.let { username ->
//                view.cvItemUser.setOnClickListener {
//                    getCallback()?.onRecyclerItemClicked(username)
//                }
//            }
        }
    }
}