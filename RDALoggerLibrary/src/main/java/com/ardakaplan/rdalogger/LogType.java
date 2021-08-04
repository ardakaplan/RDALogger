package com.ardakaplan.rdalogger;

/**
 * Created by Arda Kaplan at 4.08.2021 - 14:24
 * <p>
 * ardakaplan101@gmail.com
 */
public enum LogType {

    VERBOSE(2),
    DEBUG(3),
    INFO(4),
    WARN(5),
    ERROR(6),
    ASSERT(7),
    LIFE_CYCLE(-1);

    private int priority;

    LogType(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}
