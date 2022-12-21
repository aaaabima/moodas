/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.moodas.getmovies

import javax.inject.Inject

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version LauncherPresenter, v 0.1 2022/12/21 8:09 by Abim (Moch Arya Bima A)
 */
class LauncherPresenter @Inject constructor(
    private val view: LauncherContract.View,
): LauncherContract.Presenter {

    override fun resume() {
        // no implementation
    }

    override fun pause() {
        // no implementation
    }

    override fun destroy() {
        // no implementation
    }
}