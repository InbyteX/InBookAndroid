package com.inbyte.inbook.data.remote

import com.inbyte.inbook.BuildConfig

object EnvironmentConfig {

    enum class Environment {
        DEV,
        QA,
        PROD
    }

    private var environment = Environment.PROD

      init {
         if (BuildConfig.DEBUG) {
             environment = Environment.QA
         }
     }

    fun getInBookURl(): String =
        when (environment) {
            Environment.QA -> "http://inbyte-env.eba-f82tamcy.ap-south-1.elasticbeanstalk.com/api/"
            Environment.DEV -> "http://192.168.29.7:8080/api/"
            Environment.PROD -> ""
        }



}