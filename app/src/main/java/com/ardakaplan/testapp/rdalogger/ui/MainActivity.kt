package com.ardakaplan.testapp.rdalogger.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import com.ardakaplan.library.rdalogger.RDALogger
import com.ardakaplan.testapp.rdalogger.R

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.mainActivity_button_lifeCycle).setOnClickListener(View.OnClickListener {

            RDALogger.debug("BUTTON CLICKED")

            LifeCycleLogActivity.open(this@MainActivity)
        })


        //log to call listener
        RDALogger.info("this is INFO log")
        RDALogger.debug("this is DEBUG log")
        RDALogger.warn("this is WARN log")
        RDALogger.verbose("this is VERBOSE log")

        RDALogger.error("this is ERROR log")
        RDALogger.error(RuntimeException("TEST EXCEPTION"))
        RDALogger.error(Throwable("TEST THROWABLE"))


        //non listener logs
        RDALogger.info("this is NON LISTENER INFO log", false)
        RDALogger.debug("this is NON LISTENER DEBUG log", false)
        RDALogger.warn("this is NON LISTENER WARN log", false)
        RDALogger.verbose("this is NON LISTENER VERBOSE log", false)
        RDALogger.error("this is NON LISTENER ERROR log", false)
        RDALogger.error(RuntimeException("TEST EXCEPTION"), false)
    }
}