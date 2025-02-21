package com.ardakaplan.testapp.rdalogger.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ardakaplan.library.rdalogger.RDALogger

/**
 * Created by Arda Kaplan on 21/02/2025 at 14:31.
 *
 * ardakaplan101@gmail.com
 */
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)

        RDALogger.logLifeCycle(javaClass.simpleName)
    }

    override fun onStart() {
        super.onStart()

        RDALogger.logLifeCycle(javaClass.simpleName)
    }

    override fun onRestart() {
        super.onRestart()

        RDALogger.logLifeCycle(javaClass.simpleName)
    }

    override fun onResume() {
        super.onResume()

        RDALogger.logLifeCycle(javaClass.simpleName)
    }

    override fun onPause() {
        super.onPause()

        RDALogger.logLifeCycle(javaClass.simpleName)
    }

    override fun onStop() {
        super.onStop()

        RDALogger.logLifeCycle(javaClass.simpleName)
    }

    override fun onDestroy() {
        super.onDestroy()

        RDALogger.logLifeCycle(javaClass.simpleName)
    }

}