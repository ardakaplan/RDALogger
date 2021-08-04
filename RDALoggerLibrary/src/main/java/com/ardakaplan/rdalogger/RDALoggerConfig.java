package com.ardakaplan.rdalogger;

import android.util.Log;

import java.util.logging.Logger;

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

        Log.i(RDALOGGER_TAG, "Hello, This is RDALogger by Arda Kaplan.");

        Log.i(RDALOGGER_TAG, "For more information about usage please visit the URL -> https://github.com/ardakaplan/RDALogger ");

        Log.i(RDALOGGER_TAG, "RDALogger initialized by " + TAG);

        TAG = applicationName;

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

    public RDALoggerConfig setListener(RDALogListener rdaLogListener) {

        logListener = rdaLogListener;

        return RDA_LOGGER_CONFIG;
    }

    public interface RDALogListener {

        void onLogReceived(LogType logType, String log);
    }

}
