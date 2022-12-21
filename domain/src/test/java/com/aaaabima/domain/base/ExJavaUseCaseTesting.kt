/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.domain.base

import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Before

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version ExJavaUseCaseTesting, v 0.1 2022/12/21 12:36 by Abim (Moch Arya Bima A)
 */
open class ExJavaUseCaseTesting() {
    @Before
    fun setUp() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
    }
}