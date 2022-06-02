package com.inbyte.inbook.view.ui.welcome

import android.app.Application
import com.inbyte.inbook.view.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor(private val app: Application) : BaseViewModel(app)