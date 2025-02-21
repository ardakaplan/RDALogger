package com.ardakaplan.library.rdalogger

/**
 * Created by Arda Kaplan on 21/02/2025 at 14:52.
 *
 * ardakaplan101@gmail.com
 */
interface RDALogListener {

    /**
     * if you want to save every logs into file or database , you should use this method
     *
     * @param rdaLogFullData has full data about the log
     *                       anchor,logType,className,lineNumber,methodName,pureLog
     */
    fun onLogReceived(rdaLogFullData : RDALogFullData)
}