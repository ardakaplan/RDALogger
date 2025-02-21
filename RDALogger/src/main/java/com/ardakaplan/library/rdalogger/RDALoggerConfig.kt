package com.ardakaplan.library.rdalogger

import android.util.Log

/**
 * Created by Arda Kaplan on 21/02/2025 at 14:51.
 *
 * ardakaplan101@gmail.com
 */
object RDALoggerConfig {

    var enableLifeCycleLogs : Boolean = false

    var enableLogs : Boolean = false

    var rdaLogListener : RDALogListener? = null

    const val RDALOGGER_TAG : String = "RDALogger"

    var TAG : String = RDALOGGER_TAG

    /**
     * To use RDALogger; call this first and enable logging mechanism by calling specific methods
     *
     * @param applicationName application name will be showed in logcat
     * @return RDALoggerConfig instance
     */
    fun setup(applicationName : String) : RDALoggerConfig {

        this.TAG = applicationName

        printStartingTable()

        return this
    }

    private fun printStartingTable() {

        val line1 = "Hello, This is RDALogger by Arda Kaplan."
        val line2 = "For more information about usage please visit -> https://github.com/ardakaplan/RDALogger "
        val line3 = "RDALogger initialized by $TAG"

        val maxContentLength = listOf(line1, line2, line3).maxOf { it.length }

        val beginning = "****   "
        val ending = "   ****"

        val border = "*".repeat(maxContentLength + beginning.length + ending.length)

        // Format each line to include the ** at the start and end, padding with spaces if needed
        val formattedLine1 = "$beginning${line1.padEnd(maxContentLength)}$ending"
        val formattedLine2 = "$beginning${line2.padEnd(maxContentLength)}$ending"
        val formattedLine3 = "$beginning${line3.padEnd(maxContentLength)}$ending"

        // Print the banner to Logcat
        Log.i(RDALOGGER_TAG, border)
        Log.i(RDALOGGER_TAG, formattedLine1)
        Log.i(RDALOGGER_TAG, formattedLine2)
        Log.i(RDALOGGER_TAG, formattedLine3)
        Log.i(RDALOGGER_TAG, border)
    }

    /**
     * enables normal logging info/debug/warn/error
     *
     * @param enabled true or false
     * @return RDALoggerConfig instance
     */
    fun enableLogging(enabled : Boolean) : RDALoggerConfig {

        this.enableLogs = enabled

        Log.i(RDALOGGER_TAG, "RDALogger logging enability : $enableLogs")

        return this
    }

    /**
     * enables life cycle logging when integrated with RDALibrary
     *
     * @param enabled true or false
     * @return RDALoggerConfig instance
     */
    fun enableLifeCycleLogging(enabled : Boolean) : RDALoggerConfig {

        this.enableLifeCycleLogs = enabled

        Log.i(RDALOGGER_TAG, "RDALogger life cycle logging enability : $enableLifeCycleLogs")

        return this
    }

    /**
     * setting callback for listening every log
     *
     * @param rdaLogListener listener
     * @return RDALoggerConfig instance
     */
    fun setListener(rdaLogListener : RDALogListener?) : RDALoggerConfig {

        this.rdaLogListener = rdaLogListener

        Log.i(RDALOGGER_TAG, "RDALogger logging listener set")

        return this
    }
}
