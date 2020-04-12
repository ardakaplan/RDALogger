package com.ardakaplan.rdalogger

import android.util.Log

/**
 * Created by Arda Kaplan at 12-Apr-20
 *
 * arda.kaplan09@gmail.com
 */
class KotlinClassHelper {

    companion object {

        /**
         * @return if given class is in java or kotlin
         */
        fun Class<*>.isKotlinClass(): Boolean {

            Log.i("adad", this.name)

            return this.declaredAnnotations.any {

                it.annotationClass.qualifiedName == "kotlin.Metadata"
            }
        }
    }
}