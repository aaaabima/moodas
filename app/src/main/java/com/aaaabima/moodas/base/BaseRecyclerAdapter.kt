/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.moodas.base

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version BaseRecyclerAdapter, v 0.1 06/12/22 15.35 by Abim (Moch Arya Bima A)
 */
abstract class BaseRecyclerAdapter<
    Model,
    VH : BaseRecyclerAdapter<Model, VH>.BaseViewHolder>(
    protected var context: Context?
) : RecyclerView.Adapter<VH>() {

    private var modelList = mutableListOf<Model>()
    private var inflater: LayoutInflater = LayoutInflater.from(context)
    private var recyclerCallback: AdapterOnClick? = null

    override fun onBindViewHolder(holder: VH, position: Int) =
        holder.onBind(modelList[position]) // reversed order insert

    override fun getItemCount(): Int = modelList.size

    protected abstract fun getResLayout(type: Int): Int

    fun setOnItemClickListener(listener: AdapterOnClick) {
        recyclerCallback = listener
    }

    protected fun getCallback() = recyclerCallback

    fun insertAndNotify(models: List<Model>?) {
        if (models != null && models.isNotEmpty()) {
            modelList.addAll(models)
            if (modelList.size - models.size == 0) {
                notifyDataSetChanged()
            } else {
                notifyItemRangeInserted(modelList.size - models.size, models.size)
            }
        }
    }

    fun insertAndNotify(model: Model) {
        modelList.add(model)
        if (modelList.size == 1) {
            notifyDataSetChanged()
        } else {
            notifyItemRangeInserted(modelList.size - 1, 1)
        }
    }

    fun clearAndNotify() {
        modelList.clear()
        notifyDataSetChanged()
    }

    abstract inner class BaseViewHolder(val view: ViewBinding): RecyclerView.ViewHolder(view.root) {

        abstract fun onBind(model: Model)
    }

    interface AdapterOnClick {

        fun onRecyclerItemClicked(extra: String)
    }
}