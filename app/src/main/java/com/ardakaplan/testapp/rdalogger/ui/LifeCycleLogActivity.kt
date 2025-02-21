package com.ardakaplan.testapp.rdalogger.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.ardakaplan.testapp.rdalogger.R

/**
 * Created by Arda Kaplan on 21/02/2025 at 16:36.
 *
 * ardakaplan101@gmail.com
 */
class LifeCycleLogActivity : BaseActivity() {

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.life_cycle_log_activity)
    }

    companion object {

        fun open(activity : Activity) = activity.startActivity(Intent(activity, LifeCycleLogActivity::class.java))
    }
}