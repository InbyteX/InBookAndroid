package com.inbyte.inbook.view.ui.base


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.inbyte.inbook.data.error.errorUsecase.ErrorManager
import javax.inject.Inject

open class BaseViewModel constructor(app:Application) : AndroidViewModel(app) {

   val loaderVisibility = MutableLiveData<Boolean>()

    val screenTitle = MutableLiveData<String>()
    var screenTitleBarVisibility :Boolean = false
    var screenBackVisibility = true




}