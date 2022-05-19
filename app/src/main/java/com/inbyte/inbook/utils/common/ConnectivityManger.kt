package com.inbyte.inbook.utils.common

import android.app.Application
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class ConnectivityManger @Inject constructor(application: Application) {

    private val networkConnection = NetworkConnection(application)

    //observer
    private val isNetworkAvailable = MutableLiveData(true)
    val networkAvailable:LiveData<Boolean> = isNetworkAvailable

    fun registerConnectionObserver(lifecycleOwner: LifecycleOwner){
        networkConnection.observe(lifecycleOwner){
            isconnected-> isconnected?.let {
                isNetworkAvailable.value = it
        }
        }
    }
}