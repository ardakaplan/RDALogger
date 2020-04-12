package com.ardakaplan.myapplication

import com.ardakaplan.rdalogger.RDALogger

/**
 * Created by Arda Kaplan at 12-Apr-20 - 15:16
 *
 * ardakaplan101@gmail.com
 */
class KotlinClass {

    companion object {

        fun test2() {

            RDALogger.info("THIS IS KOTLIN LOG")
        }
    }


    fun test() {

        RDALogger.info("THIS IS KOTLIN LOG")

//        JavaClass.test()
    }

}