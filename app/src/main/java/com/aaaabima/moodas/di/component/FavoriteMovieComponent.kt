/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.moodas.di.component

import com.aaaabima.moodas.di.PerActivity
import com.aaaabima.moodas.di.module.FavoriteMovieModule
import com.aaaabima.moodas.favoritemovie.FavoriteMovieActivity
import dagger.Component

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version FavoriteMovieModule, v 0.1 12/14/2022 10:57 PM by Abim (Moch Arya Bima A)
 */
@PerActivity
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [FavoriteMovieModule::class]
)
interface FavoriteMovieComponent {

    fun inject(activity: FavoriteMovieActivity)
}