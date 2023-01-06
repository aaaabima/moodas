/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2023 All Rights Reserved.
 */

package com.aaaabima.moodas.di.component

import com.aaaabima.moodas.di.PerActivity
import com.aaaabima.moodas.di.module.NowPlayingMoviesModule
import com.aaaabima.moodas.getmovies.NowPlayingMoviesFragment
import dagger.Component

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version NowPlayingMoviesComponent, v 0.1 06/01/23 10.14 by Abim (Moch Arya Bima A)
 */
@PerActivity
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [NowPlayingMoviesModule::class]
)
interface NowPlayingMoviesComponent {

    fun inject(fragment: NowPlayingMoviesFragment)
}