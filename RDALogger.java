package com.ardakaplan.encryptor.ui;

import android.util.Log;

/**
 * Created by ardakaplan on 22/09/17.
 * <p/>
 * www.ardakaplan.com
 * <p/>
 * arda.kaplan09@gmail.com
 */
public final class RDALogger {

    private static final String METHOD_CALLED = "   ///   METHOD_CALLED";
    private static final String IN_CLASS = "IN CLASS : ";
    private static final String IN_METHOD = "   ///   IN METHOD : ";
    private static final String ANCHOR = "   ///   ANCHOR : ";
    private static RDALogger rdaLogger = null;
    private static boolean enableLifeCycleLogs = false;
    private static boolean enableLogs = false;
    private static boolean enableHttpLogs = false;
    private static String TAG = "";

    private RDALogger() {

    }

    public static RDALogger start(String applicationName) {

        rdaLogger = new RDALogger();

        TAG = applicationName;

        Log.i(TAG, " RDALogger initialized by " + TAG);

        return rdaLogger;
    }

    private static StackTraceElement getStackTraceElement(int index) {

        return Thread.currentThread().getStackTrace()[index];
    }

    private static String getMethodName() {

        return getStackTraceElement(5).getMethodName();
    }

    private static int getLineNumber() {

        return getStackTraceElement(5).getLineNumber();
    }

    private static String getClassName() {

        String className = getStackTraceElement(5).getClassName();

        int lastIndexOfPoint = className.lastIndexOf(".");

        className = className.substring(lastIndexOfPoint + 1, className.length());

        return className;
    }

    private static String getAnchorLink(String className, int lineNumber) {

        return "(" + className + ".java:" + lineNumber + ")";
    }

    /**
     * Yasam dongusu loglari icin, sadece sinif ismiyle cagrilmasi yeter
     *
     * @param className
     */
    public static void logLifeCycle(String className) {

        if (enableLifeCycleLogs && enableLogs) {

            Log.d(TAG, IN_CLASS + className + IN_METHOD + getMethodName() + METHOD_CALLED + ANCHOR + getAnchorLink(getClassName(), getLineNumber()));
        }
    }

    public static void logHttpRequest(Object text) {

        text = checkUsage(text);

        if (enableHttpLogs && enableLogs) {

            Log.v(TAG, IN_CLASS + getClassName() + IN_METHOD + getMethodName() + ANCHOR + getAnchorLink(getClassName(), getLineNumber()) + "\n" + text.toString() + "\n   ");
        }
    }

    public static void info(Object text) {

        text = checkUsage(text);

        if (enableLogs) {

            Log.i(TAG, IN_CLASS + getClassName() + IN_METHOD + getMethodName() + ANCHOR + getAnchorLink(getClassName(), getLineNumber()) + "\n" + text.toString() + "\n   ");
        }
    }


    public static void debug(Object text) {

        text = checkUsage(text);

        if (enableLogs) {

            Log.d(TAG, IN_CLASS + getClassName() + IN_METHOD + getMethodName() + ANCHOR + getAnchorLink(getClassName(), getLineNumber()) + "\n" + text.toString() + "\n   ");
        }
    }

    public static void warn(Object text) {

        text = checkUsage(text);

        if (enableLogs) {

            Log.w(TAG, IN_CLASS + getClassName() + IN_METHOD + getMethodName() + ANCHOR + getAnchorLink(getClassName(), getLineNumber()) + "\n" + text.toString() + "\n   ");
        }
    }

    public static void verbose(Object text) {

        text = checkUsage(text);

        if (enableLogs) {

            Log.v(TAG, IN_CLASS + getClassName() + IN_METHOD + getMethodName() + ANCHOR + getAnchorLink(getClassName(), getLineNumber()) + "\n" + text.toString() + "\n   ");
        }
    }

    private static Object checkUsage(Object object) {

        if (object == null) {

            return "OBJECT IS NULL, NOTHING TO SHOW.";

        } else {

            return object;
        }
    }

    public static void error(Object text) {

        text = checkUsage(text);

        if (enableLogs) {


            Log.e(TAG, IN_CLASS + getClassName() + IN_METHOD + getMethodName() + ANCHOR + getAnchorLink(getClassName(), getLineNumber()) + " \n" + text.toString() + "\n   ");
        }
    }

    public static void error(Throwable throwable) {

        if (throwable != null && enableLogs) {

            Log.e(TAG, IN_CLASS + getClassName() + IN_METHOD + getMethodName() + ANCHOR + getAnchorLink(getClassName(), getLineNumber()), throwable);
        }
    }

    public static void error(Object text, Throwable throwable) {

        text = checkUsage(text);

        if (throwable != null && enableLogs) {

            Log.e(TAG, IN_CLASS + getClassName() + IN_METHOD + getMethodName() + ANCHOR + getAnchorLink(getClassName(), getLineNumber()) + " \n" + text.toString() + "\n   ", throwable);
        }
    }

    public RDALogger enableLogging(boolean enability) {

        enableLogs = enability;

        Log.i(TAG, " RDALogger logging enability : " + enableLogs);

        return rdaLogger;
    }

    public RDALogger enableLifeCycleLogging(boolean enability) {

        enableLifeCycleLogs = enability;

        Log.i(TAG, " RDALogger life cycle logging enability : " + enableLifeCycleLogs);

        return rdaLogger;
    }

    public RDALogger enableHttpLogging(boolean enability) {

        enableHttpLogs = enability;

        Log.i(TAG, " RDALogger http logging enability : " + enableHttpLogs);

        return rdaLogger;
    }


}
