package com.inbyte.inbook.view.ui.authentication.register

import android.app.Application
import com.inbyte.inbook.view.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    app:Application
):BaseViewModel(app) {
}