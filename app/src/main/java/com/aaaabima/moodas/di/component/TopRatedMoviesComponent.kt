/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2023 All Rights Reserved.
 */

package com.aaaabima.moodas.di.component

import com.aaaabima.moodas.di.PerActivity
import com.aaaabima.moodas.di.module.TopRatedMoviesModule
import com.aaaabima.moodas.getmovies.TopRatedMoviesFragment
import dagger.Component

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version TopRatedMoviesComponent, v 0.1 06/01/23 11.07 by Abim (Moch Arya Bima A)
 */
@PerActivity
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [TopRatedMoviesModule::class]
)
interface TopRatedMoviesComponent {

    fun inject(fragment: TopRatedMoviesFragment)
}