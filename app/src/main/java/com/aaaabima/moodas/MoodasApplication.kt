/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.moodas

import android.app.Application
import com.aaaabima.moodas.di.component.ApplicationComponent

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version Moodas, v 0.1 06/12/22 15.13 by Abim (Moch Arya Bima A)
 */
class MoodasApplication: Application() {
    private lateinit var applicationComponent: ApplicationComponent
}