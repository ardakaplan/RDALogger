package com.ardakaplan.testapp.rdalogger

import android.app.Application
import com.ardakaplan.library.rdalogger.RDALogFullData
import com.ardakaplan.library.rdalogger.RDALogListener
import com.ardakaplan.library.rdalogger.RDALoggerConfig

/**
 * Created by Arda Kaplan on 21/02/2025 at 15:23.
 *
 * ardakaplan101@gmail.com
 */
class RDALoggerTestApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        RDALoggerConfig.setup(getString(R.string.app_name))//label that you want to see in logcat (ex. application name)
            .enableLogging(true)//enable log mechanizm, default is false
            .enableLifeCycleLogging(true)//enable life cycle log mechanizm, default is false
            .setListener(object : RDALogListener {//log listener

                override fun onLogReceived(rdaLogFullData : RDALogFullData) {
                    /**
                     *{@link RDALogFullData} has full data about the log,
                     * anchor,logType,className,lineNumber,methodName,pureLog
                     *
                     * called for every written logs,
                     *
                     * save to database, write to file, do what you want with this full log item
                     */
                    /**
                     *{@link RDALogFullData} has full data about the log,
                     * anchor,logType,className,lineNumber,methodName,pureLog
                     *
                     * called for every written logs,
                     *
                     * save to database, write to file, do what you want with this full log item
                     */


//                    Log.i(
//                        getString(R.string.app_name), "LOG LISTENER TEST ->\n" +
//                                "anchor -> " + rdaLogFullData.anchorLink + "\n" +
//                                "logType -> " + rdaLogFullData.logType.name + "\n" +
//                                "className -> " + rdaLogFullData.className + "\n" +
//                                "lineNumber -> " + rdaLogFullData.lineNumber + "\n" +
//                                "methodName -> " + rdaLogFullData.methodName + "\n" +
//                                "pureLog -> " + rdaLogFullData.pureLog
//                    )
                }
            });
    }
}