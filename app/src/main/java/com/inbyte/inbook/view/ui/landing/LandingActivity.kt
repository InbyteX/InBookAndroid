package com.inbyte.inbook.view.ui.landing

import android.os.Bundle
import androidx.activity.viewModels
import com.inbyte.inbook.R
import com.inbyte.inbook.databinding.ActivityLandingBinding
import com.inbyte.inbook.view.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LandingActivity : BaseActivity<ActivityLandingBinding, LandingViewModel>() {

    override val viewModel: LandingViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)
    }

    override fun init() {
        viewModel.screenTitle.value = "login page" // todo: need to get from string resource
    }

    override fun initCtrl() {}

    override fun observer() {}


}
