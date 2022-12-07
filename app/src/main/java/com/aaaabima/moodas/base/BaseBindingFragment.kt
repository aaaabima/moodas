/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.moodas.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version BaseBindingFragment, v 0.1 06/12/22 15.35 by Abim (Moch Arya Bima A)
 */
abstract class BaseBindingFragment : Fragment() {

    @LayoutRes
    abstract fun contentView(): Int
    protected abstract fun setupData(savedInstanceState: Bundle?)
    protected abstract fun setupView()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setupData(savedInstanceState)
        return inflater.inflate(contentView(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }
}