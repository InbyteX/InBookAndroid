package com.inbyte.inbook.utils.common

import android.util.Log
import com.inbyte.inbook.BuildConfig

class Logger {

    companion object {

        fun verbose(tag: String, message: String) {
            if (BuildConfig.DEBUG) Log.v(tag, message)
        }

        fun info(tag: String, message: String) {
            if (BuildConfig.DEBUG) Log.i(tag, message)
        }

        fun debug(tag: String, message: String) {
            if (BuildConfig.DEBUG) Log.d(tag, message)
        }

        fun error(tag: String, ex: Exception?) {
            if (BuildConfig.DEBUG) ex?.printStackTrace()
            else {
                ex?.message?.let {
                    Log.e(tag, it)
                }
            }
        }

        fun error(tag: String, message: String) {
            if (BuildConfig.DEBUG) Log.e(tag, message)
        }

    }
}