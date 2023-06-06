package com.ardakaplan.rdalogger;

/**
 * To use this class, once you must initialize and set log mechanism for normal/http or lifecycle
 * <p>
 * RDALogger.initialize("appname").enableLogging(true).enableLifeCycleLogging(true).enableHttpLogging(true);
 * <p>
 * And than call static info/debug/warn/error methods whereever you want
 * <p>
 * <p>
 * Created by ardakaplan on 22/09/17.
 * <p/>
 * www.ardakaplan.com
 * <p/>
 * arda.kaplan09@gmail.com
 */

public final class RDALoggerNonListened extends BaseRDALogger {

    /**
     * private constructor
     */
    private RDALoggerNonListened() {

    }

    public static void info(Object object) {

        log(LogType.INFO, object);
    }

    public static void debug(Object object) {

        log(LogType.DEBUG, object);
    }

    public static void warn(Object object) {

        log(LogType.WARN, object);
    }

    public static void verbose(Object object) {

        log(LogType.VERBOSE, object);
    }

    public static void error(String message) {

        log(LogType.ERROR, message);
    }

    public static void error(Exception exception) {

        log(LogType.ERROR, exception);
    }

    private static void log(LogType logType, Object object) {

        log(logType, object, false, false);

    }
}