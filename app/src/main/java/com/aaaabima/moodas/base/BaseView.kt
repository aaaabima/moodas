/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.moodas.base

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version BaseView, v 0.1 06/12/22 15.34 by Abim (Moch Arya Bima A)
 */
interface BaseView {

    fun showProgress()
    fun dismissProgress()
    fun onError(errorMessage: String?)
}