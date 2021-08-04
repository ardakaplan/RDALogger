package com.ardakaplan.myapplication;

import android.app.Application;
import android.util.Log;

import com.ardakaplan.rdalogger.LogType;
import com.ardakaplan.rdalogger.RDALoggerConfig;

import java.util.logging.Logger;

/**
 * Created by Arda Kaplan at 11-Apr-20
 * <p>
 * arda.kaplan09@gmail.com
 */
public class RDALoggerApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        RDALoggerConfig.setup(getString(R.string.app_name))
                .enableLogging(true)
                .enableLifeCycleLogging(true)
                .setListener(new RDALoggerConfig.RDALogListener() {

                    @Override
                    public void onLogReceived(LogType logType, String log) {

                        Log.i(getString(R.string.app_name), "LOG LISTENER TEST ->" + logType.name() + " " + log);
                    }
                });
    }
}
