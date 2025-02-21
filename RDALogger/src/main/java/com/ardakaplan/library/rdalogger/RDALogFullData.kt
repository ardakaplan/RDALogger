package com.ardakaplan.library.rdalogger

/**
 * Created by Arda Kaplan on 21/02/2025 at 14:47.
 *
 * ardakaplan101@gmail.com
 */
data class RDALogFullData(
    val logType : LogType,
    val className : String,
    val lineNumber : Int,
    val methodName : String,
    val pureLog : String,

    ) {
    var anchorLink : String = ""

    init {

        anchorLink = try {

            val act = Class.forName(Thread.currentThread().stackTrace[7].className)

            if (act.getAnnotation(Metadata::class.java) != null) {

                "($className.kt:$lineNumber)"

            } else {

                "($className.java:$lineNumber)"
            }

        } catch (ignored : ClassNotFoundException) {

            "couldn't find the class"
        }
    }
}