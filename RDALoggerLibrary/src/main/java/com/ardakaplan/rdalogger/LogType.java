package com.ardakaplan.rdalogger;

import android.util.Log;

/**
 * Created by Arda Kaplan at 4.08.2021 - 14:24
 * <p>
 * ardakaplan101@gmail.com
 */
public enum LogType {

    VERBOSE(Log.VERBOSE),
    DEBUG(Log.DEBUG),
    INFO(Log.INFO),
    WARN(Log.WARN),
    ERROR(Log.ERROR),
    //    ASSERT(Log.ASSERT),
    LIFE_CYCLE(-1);

    private final int priority;

    LogType(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}
