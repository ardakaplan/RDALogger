package com.ardakaplan.rdalogger;

import android.util.Log;

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

public final class RDALogger {

    private static final String IN_CLASS = "IN CLASS : ";
    private static final String IN_METHOD = "   ---   IN METHOD : ";

    private RDALoggerConfig rdaLoggerConfig;

    /**
     * singleton design pattern
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

    public static void error(Object object) {

        log(LogType.ERROR, object, false);
    }

    private static void log(LogType logType, Object object, boolean isLifeCycle) {

        if (RDALoggerConfig.enableLogs) {

            RDALogFullData logItem = getLogcatLog(logType, object, isLifeCycle);

            String log;

            if (isLifeCycle) {

                log = logItem.getAnchorLink() + " - " + logItem.getMethodName() + " called";

            } else {

                log = logItem.getAnchorLink() + " - " + logItem.getMethodName() + "() -> " + logItem.getPureLog();
            }

            switch (logType) {

                case INFO:

                    Log.i(RDALoggerConfig.TAG, log);

                    break;

                case DEBUG:

                    Log.d(RDALoggerConfig.TAG, log);

                    break;

                case WARN:

                    Log.w(RDALoggerConfig.TAG, log);

                    break;

                case ERROR:

                    Log.e(RDALoggerConfig.TAG, log);

                    break;

                case VERBOSE:
                case LIFE_CYCLE:

                    Log.v(RDALoggerConfig.TAG, log);

                    break;

            }

            if (RDALoggerConfig.logListener != null) {

                RDALoggerConfig.logListener.onLogReceived(logItem);

            }
        }
    }

//    public static void error(Throwable throwable) {
//
//        if (throwable != null && RDALoggerConfig.enableLogs) {
//
//            Log.e(RDALoggerConfig.TAG, "", throwable);
//        }
//    }
//
//    public static void error(Object text, Throwable throwable) {
//
//        if (throwable != null && RDALoggerConfig.enableLogs) {
//
//            Log.e(RDALoggerConfig.TAG, editMessage(text), throwable);
//        }
//    }

    private static RDALogFullData getLogcatLog(LogType logType, Object object, boolean isLifeCycle) {

        if (isLifeCycle) {

            return new RDALogFullData(logType, object.toString(), 0, StackTraceProcesses.getMethodName(), "");

        } else {

            return new RDALogFullData(logType, StackTraceProcesses.getClassName(), StackTraceProcesses.getLineNumber(), StackTraceProcesses.getMethodName(), checkUsage(object).toString());
        }
    }

    private static StackTraceElement getStackTrace() {

        return Thread.currentThread().getStackTrace()[9];
    }

    private static Object checkUsage(Object object) {

        if (object == null) {

            return "OBJECT IS NULL, NOTHING TO SHOW.";

        } else {

            return object;
        }
    }

    /*
     *All StackTrace operations should be in this class for better understanding
     */
    private static class StackTraceProcesses {

        private static String getMethodName() {

            return getStackTrace().getMethodName();
        }

        private static int getLineNumber() {

            return getStackTrace().getLineNumber();
        }

        private static String getClassName() {

            String className = getStackTrace().getClassName();

            className = className.substring(className.lastIndexOf(".") + 1);

            //inner classes put $ on the classname, so we clear it off
            if (className.contains("$")) {

                className = className.substring(0, className.indexOf("$"));
            }

            return className;
        }
    }
}