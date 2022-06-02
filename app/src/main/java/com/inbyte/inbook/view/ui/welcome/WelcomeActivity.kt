package com.inbyte.inbook.view.ui.welcome

import android.os.Bundle
import androidx.activity.viewModels
import com.inbyte.inbook.R
import com.inbyte.inbook.databinding.ActivityWelcomeBinding
import com.inbyte.inbook.view.ui.base.BaseActivity
import com.inbyte.inbook.view.ui.welcome.adapter.PageAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WelcomeActivity : BaseActivity<ActivityWelcomeBinding, WelcomeViewModel>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        binding.welcomeScreenViewpager.adapter = PageAdapter(supportFragmentManager)
        binding.tabLayout.setupWithViewPager(binding.welcomeScreenViewpager,true)

    }

    override val viewModel: WelcomeViewModel by viewModels()
    override fun init() {}

    override fun initCtrl() {}

    override fun observer() {}


}