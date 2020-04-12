package com.ardakaplan.myapplication;

import android.app.Application;

import com.ardakaplan.rdalogger.RDALoggerConfig;

/**
 * Created by Arda Kaplan at 11-Apr-20
 * <p>
 * arda.kaplan09@gmail.com
 */
public class RDALoggerApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        RDALoggerConfig.setup(getString(R.string.app_name)).enableLogging(true);
    }
}
