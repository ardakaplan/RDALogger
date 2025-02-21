package com.ardakaplan.library.rdalogger

import android.util.Log
import java.io.PrintWriter
import java.io.StringWriter
import java.io.Writer

/**
 * Created by Arda Kaplan on 21/02/2025 at 14:56.
 *
 * ardakaplan101@gmail.com
 */
object RDALogger {

    /**
     * Every lifecycle method must use this method for logging,
     *
     * must use in base class
     *
     * @param className className, fragment or activity name
     */
    fun logLifeCycle(className : String, callListener : Boolean = true) {

        if (RDALoggerConfig.enableLifeCycleLogs) {

            log(LogType.LIFE_CYCLE, className, true, callListener)
        }
    }

    fun info(`object` : Any, callListener : Boolean = true) = log(LogType.INFO, `object`, false, callListener)

    fun debug(`object` : Any, callListener : Boolean = true) = log(LogType.DEBUG, `object`, false, callListener)

    fun warn(`object` : Any, callListener : Boolean = true) = log(LogType.WARN, `object`, false, callListener)

    fun verbose(`object` : Any, callListener : Boolean = true) = log(LogType.VERBOSE, `object`, false, callListener)

    fun error(message : String, callListener : Boolean = true) = log(LogType.ERROR, message, false, callListener)

    fun error(throwable : Throwable, callListener : Boolean = true) = log(LogType.ERROR, throwable, false, callListener)

    private fun log(logType : LogType, `object` : Any, isLifeCycle : Boolean = false, callListener : Boolean = false) {

        if (RDALoggerConfig.enableLogs) {

            val logItem = getLogcatLog(logType, `object`, isLifeCycle)

            val log : String = if (isLifeCycle) {

                (logItem.anchorLink + " - " + logItem.methodName + " called")

            } else {

                (logItem.anchorLink + " - " + logItem.methodName + "() -> " + logItem.pureLog)
            }

            when (logType) {

                LogType.INFO -> Log.i(RDALoggerConfig.TAG, log)

                LogType.DEBUG -> Log.d(RDALoggerConfig.TAG, log)

                LogType.WARN -> Log.w(RDALoggerConfig.TAG, log)

                LogType.ERROR -> Log.e(RDALoggerConfig.TAG, log)

                LogType.VERBOSE, LogType.LIFE_CYCLE -> Log.v(RDALoggerConfig.TAG, log)
            }

            if (RDALoggerConfig.rdaLogListener != null && callListener) {

                RDALoggerConfig.rdaLogListener!!.onLogReceived(logItem)
            }
        }
    }

    private fun getLogcatLog(logType : LogType, `object` : Any, isLifeCycle : Boolean) : RDALogFullData {

        val className : String
        val lineNumber : Int
        var pureLog = ""

        if (isLifeCycle) {

            className = `object`.toString()

            lineNumber = 0

        } else {

            lineNumber = StackTraceProcesses.getLineNumber()
            className = StackTraceProcesses.getClassName()

            pureLog = if (`object` is Exception) {

                val writer : Writer = StringWriter()

                `object`.printStackTrace(PrintWriter(writer))

                writer.toString()

            } else {

                checkUsage(`object`).toString()
            }
        }

        return RDALogFullData(logType, className, lineNumber, StackTraceProcesses.getMethodName(), pureLog)
    }

    private fun checkUsage(`object` : Any?) : Any = `object` ?: "OBJECT IS NULL, NOTHING TO SHOW."

    /*
     * All StackTrace operations should be in this class for better understanding
     */
    object StackTraceProcesses {

        private fun getStackTrace() : StackTraceElement? {

            return try {

                return Thread.currentThread().stackTrace[8]

            } catch (e : Exception) {

                null
            }
        }

        fun getMethodName() : String = getStackTrace()?.methodName ?: "not_found"

        fun getLineNumber() : Int = getStackTrace()?.lineNumber ?: 0

        fun getClassName() : String {

            var className : String = getStackTrace()?.className ?: "not_found"

            className = className.substring(className.lastIndexOf(".") + 1)

            //inner classes put $ on the classname, so we clear it off
            if (className.contains("$")) {

                className = className.substring(0, className.indexOf("$"))
            }

            return className
        }
    }
}