/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.moodas.di.component

import com.aaaabima.moodas.di.PerActivity
import com.aaaabima.moodas.di.module.GetMoviesModule
import com.aaaabima.moodas.getmovies.GetMoviesActivity
import dagger.Component

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version GetMoviesModule, v 0.1 06/12/22 15.42 by Abim (Moch Arya Bima A)
 */
@PerActivity
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [GetMoviesModule::class]
)
interface GetMoviesComponent {

    fun inject(activity: GetMoviesActivity)
}