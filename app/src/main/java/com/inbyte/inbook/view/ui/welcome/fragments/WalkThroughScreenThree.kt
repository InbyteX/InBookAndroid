package com.inbyte.inbook.view.ui.welcome.fragments

import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.inbyte.inbook.R
import com.inbyte.inbook.databinding.FragmentWalkThroughScreenThreeBinding
import com.inbyte.inbook.view.ui.base.BaseFragment
import com.inbyte.inbook.view.ui.landing.LandingActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class WalkThroughScreenThree @Inject constructor(private val app:Application) : BaseFragment<FragmentWalkThroughScreenThreeBinding>(), View.OnClickListener {


    companion object {

        fun newInstance(): Fragment {
            return WalkThroughScreenThree(app = Application())
        }
    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    )= FragmentWalkThroughScreenThreeBinding.inflate(inflater,container,false)

    override fun init() {
        binding.skipBtn.setOnClickListener(this)
    }

    override fun initCtrl() {}

    override fun observer() {}

    override fun onClick(v: View?) {
        when(v?.id){
            binding.skipBtn.id ->{
                val intent = Intent(activity,LandingActivity::class.java)
                startActivity(intent)
                activity?.finish()
            }
        }
    }
}