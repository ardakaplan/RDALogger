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

public final class RDALogger extends BaseRDALogger {

    /**
     * private constructor
     */
    private RDALogger() {

    }

    /**
     * Every lifecycle method must use this method for logging,
     * <p>
     * must use in base class
     *
     * @param className className, fragment or activity name
     */
    public static void logLifeCycle(String className) {

        if (RDALoggerConfig.enableLifeCycleLogs) {

            log(LogType.LIFE_CYCLE, className, true);
        }
    }

    public static void info(Object object) {

        log(LogType.INFO, object, false);
    }

    public static void debug(Object object) {

        log(LogType.DEBUG, object, false);
    }

    public static void warn(Object object) {

        log(LogType.WARN, object, false);
    }

    public static void verbose(Object object) {

        log(LogType.VERBOSE, object, false);
    }

    public static void error(String message) {

        log(LogType.ERROR, message, false);
    }

    public static void error(Exception exception) {

        log(LogType.ERROR, exception, false);
    }

    private static void log(LogType logType, Object object, boolean isLifeCycle) {

        log(logType, object, isLifeCycle, true);

    }
}