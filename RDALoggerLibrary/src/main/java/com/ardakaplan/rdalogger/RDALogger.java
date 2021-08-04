package com.ardakaplan.rdalogger;

import android.util.Log;

import kotlin.Metadata;

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
@SuppressWarnings({"SameParameterValue", "UnusedReturnValue", "unused"})
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
     *
     * @param className className, fragment or activity
     */
    public static void logLifeCycle(String className) {

        if (RDALoggerConfig.enableLifeCycleLogs && RDALoggerConfig.enableLogs) {

            String log = editMessage(className);

            Log.v(RDALoggerConfig.TAG, log);

            sendToListener(LogType.LIFE_CYCLE, log);
        }
    }

    public static void info(Object text) {

        if (RDALoggerConfig.enableLogs) {

            String log = editMessage(text);

            Log.i(RDALoggerConfig.TAG, log);

            sendToListener(LogType.INFO, log);
        }
    }

    public static void debug(Object text) {

        if (RDALoggerConfig.enableLogs) {

            String log = editMessage(text);

            Log.d(RDALoggerConfig.TAG, log);

            sendToListener(LogType.DEBUG, log);
        }
    }

    public static void warn(Object text) {

        if (RDALoggerConfig.enableLogs) {

            String log = editMessage(text);

            Log.w(RDALoggerConfig.TAG, log);

            sendToListener(LogType.WARN, log);
        }
    }

    public static void verbose(Object text) {

        if (RDALoggerConfig.enableLogs) {

            String log = editMessage(text);

            Log.v(RDALoggerConfig.TAG, log);

            sendToListener(LogType.VERBOSE, log);
        }
    }

    public static void error(Object text) {

        if (RDALoggerConfig.enableLogs) {

            String log = editMessage(text);

            Log.e(RDALoggerConfig.TAG, log);

            sendToListener(LogType.ERROR, log);
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

    private static StackTraceElement getStackTrace() {

        return Thread.currentThread().getStackTrace()[8];
    }

    private static String getAnchorLink(String className, int lineNumber, int stackTraceIndex) {

        try {

            Class<?> act = Class.forName(Thread.currentThread().getStackTrace()[stackTraceIndex].getClassName());

            if (act.getAnnotation(Metadata.class) != null) {

                return "(" + className + ".kt:" + lineNumber + ")";

            } else {

                return "(" + className + ".java:" + lineNumber + ")";
            }

        } catch (ClassNotFoundException ignored) {

//            ignored.printStackTrace();
        }

        return "could't find the class";
    }

    private static String editMessage(Object text) {

        return getAnchorLink(StackTraceProcesses.getClassName(), StackTraceProcesses.getLineNumber(), 5) + " - " + StackTraceProcesses.getMethodName() + "() -> " + checkUsage(text).toString();
    }


    private static String editMessageForLifeCycle(String className) {

        return "LIFE CYCLE LOG -> (" + className + ".java:0) " + StackTraceProcesses.getMethodName() + "  CALLED";
    }

    private static Object checkUsage(Object object) {

        if (object == null) {

            return "OBJECT IS NULL, NOTHING TO SHOW.";

        } else {

            return object;
        }
    }

    private static void sendToListener(LogType logType, String log) {

        if (RDALoggerConfig.logListener != null) {

            RDALoggerConfig.logListener.onLogReceived(logType, log);
        }
    }

    /*
     *All StackTrace operations should be in this class for better understanding
     */
    private static abstract class StackTraceProcesses {

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