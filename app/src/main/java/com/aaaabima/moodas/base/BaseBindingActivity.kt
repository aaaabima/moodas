/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.moodas.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.aaaabima.moodas.MoodasApplication

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version BaseBindingActivity, v 0.1 06/12/22 15.35 by Abim (Moch Arya Bima A)
 */
abstract class BaseBindingActivity: AppCompatActivity() {
    @LayoutRes
    protected abstract fun contentView(): Int
    protected abstract fun setupData(savedInstanceState: Bundle?)
    protected abstract fun setupView()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupData(savedInstanceState)
        setupView()
    }

    protected fun getApplicationComponent() = (application as MoodasApplication).getApplicationComponent()
}