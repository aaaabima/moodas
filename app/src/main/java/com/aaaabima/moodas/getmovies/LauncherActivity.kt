/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.moodas.getmovies

import android.content.Intent
import com.aaaabima.moodas.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aaaabima.moodas.base.BaseBindingActivity
import com.aaaabima.moodas.databinding.ActivityLauncherBinding
import javax.inject.Inject

class LauncherActivity: BaseBindingActivity<ActivityLauncherBinding>() {


    override fun contentView(): Int = R.layout.activity_launcher

    override fun setupData(savedInstanceState: Bundle?) {}

    override fun setupView() {
        binding.ivLogo.apply {
            alpha = 0f
            animate().setDuration(1500).alpha(1f).withEndAction{
                val intent = Intent(this@LauncherActivity, GetMoviesActivity::class.java)
                startActivity(intent)
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
                finish()
            }
        }
    }

    override fun getViewBinding(): ActivityLauncherBinding {
        return ActivityLauncherBinding.inflate(layoutInflater)
    }
}