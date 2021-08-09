package com.ardakaplan.rdalogger;

import android.util.Log;

/**
 * Created by Arda Kaplan at 11-Apr-20
 * <p>
 * arda.kaplan09@gmail.com
 */
@SuppressWarnings({"UnusedReturnValue", "unused"})
public final class RDALoggerConfig {

    private static final RDALoggerConfig RDA_LOGGER_CONFIG = new RDALoggerConfig();

    static boolean enableLifeCycleLogs = false;
    static boolean enableLogs = false;
    static RDALogListener logListener = null;

    private static final String RDALOGGER_TAG = "RDALogger";

    static String TAG = RDALOGGER_TAG;

    private RDALoggerConfig() {

    }

    /**
     * To use RDALogger; call this first and enable logging mechanism by calling specific methods
     *
     * @param applicationName application name will be showed in logcat
     * @return RDALoggerConfig instance
     */
    public static RDALoggerConfig setup(String applicationName) {

        TAG = applicationName;

        Log.i(RDALOGGER_TAG, "Hello, This is RDALogger by Arda Kaplan.");

        Log.i(RDALOGGER_TAG, "For more information about usage please visit -> https://github.com/ardakaplan/RDALogger ");

        Log.i(RDALOGGER_TAG, "RDALogger initialized by " + TAG);

        return RDA_LOGGER_CONFIG;
    }

    /**
     * enables normal logging info/debug/warn/error
     *
     * @param enabled true or false
     * @return RDALoggerConfig instance
     */
    public RDALoggerConfig enableLogging(boolean enabled) {

        enableLogs = enabled;

        Log.i(RDALOGGER_TAG, "RDALogger logging enability : " + enableLogs);

        return RDA_LOGGER_CONFIG;
    }

    /**
     * enables life cycle logging when integrated with RDALibrary
     *
     * @param enabled true or false
     * @return RDALoggerConfig instance
     */
    public RDALoggerConfig enableLifeCycleLogging(boolean enabled) {

        enableLifeCycleLogs = enabled;

        Log.i(RDALOGGER_TAG, "RDALogger life cycle logging enability : " + enableLifeCycleLogs);

        return RDA_LOGGER_CONFIG;
    }

    /**
     * setting callback for listening every log
     *
     * @param rdaLogListener listener
     * @return RDALoggerConfig instance
     */
    public RDALoggerConfig setListener(RDALogListener rdaLogListener) {

        logListener = rdaLogListener;

        Log.i(RDALOGGER_TAG, "RDALogger logging listener set");

        return RDA_LOGGER_CONFIG;
    }

    public interface RDALogListener {

        /**
         * if you want to save every logs into file or database , you should use this method
         *
         * @param rdaLogFullData has full data about the log
         *                       anchor,logType,className,lineNumber,methodName,pureLog
         */
        void onLogReceived(RDALogFullData rdaLogFullData);
    }

}
