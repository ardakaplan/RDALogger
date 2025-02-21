package com.ardakaplan.library.rdalogger

import android.util.Log
import androidx.annotation.IntDef

/**
 * Created by Arda Kaplan on 21/02/2025 at 14:42.
 *
 * ardakaplan101@gmail.com
 */

enum class LogType(@Priority val priority : Int) {

    VERBOSE(Log.VERBOSE),
    DEBUG(Log.DEBUG),
    INFO(Log.INFO),
    WARN(Log.WARN),
    ERROR(Log.ERROR),
    LIFE_CYCLE(-1);

    companion object {
        @Retention(AnnotationRetention.SOURCE)
        @IntDef(Log.ASSERT, Log.ERROR, Log.WARN, Log.INFO, Log.DEBUG, Log.VERBOSE)
        annotation class Priority
    }
}