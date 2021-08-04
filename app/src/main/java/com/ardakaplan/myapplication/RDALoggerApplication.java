package com.ardakaplan.myapplication;

import android.app.Application;

import com.ardakaplan.rdalogger.RDALogFullData;
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

        RDALoggerConfig.setup(getString(R.string.app_name))//label that you want to see in logcat (ex. application name)
                .enableLogging(true)//enable log mechanizm, default is false
                .enableLifeCycleLogging(false)//enable life cycle log mechanizm, default is false
                .setListener(new RDALoggerConfig.RDALogListener() {//log listener

                    @Override
                    public void onLogReceived(RDALogFullData rdaLogFullData) {

                        /**
                         *{@link RDALogFullData} has full data about the log,
                         * anchor,logType,className,lineNumber,methodName,pureLog
                         *
                         * called for every written logs,
                         *
                         * save to database, write to file, do what you want with this full log item
                         */

//                        Log.i(getString(R.string.app_name), "LOG LISTENER TEST ->\n" +
//                                "anchor -> " + rdaLogFullData.getAnchorLink() + "\n" +
//                                "logType -> " + rdaLogFullData.getLogType().name() + "\n" +
//                                "className -> " + rdaLogFullData.getClassName() + "\n" +
//                                "lineNumber -> " + rdaLogFullData.getLineNumber() + "\n" +
//                                "methodName -> " + rdaLogFullData.getMethodName() + "\n" +
//                                "pureLog -> " + rdaLogFullData.getPureLog()
//                        );
                    }
                });
    }
}
