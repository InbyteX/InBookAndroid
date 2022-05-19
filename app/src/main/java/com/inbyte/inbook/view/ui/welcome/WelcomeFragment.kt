package com.inbyte.inbook.view.ui.welcome

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.inbyte.inbook.R
import com.inbyte.inbook.databinding.FragmentWelcomeBinding
import com.inbyte.inbook.view.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WelcomeFragment : BaseFragment<FragmentWelcomeBinding>(), View.OnClickListener {

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentWelcomeBinding.inflate(inflater, container, false)

    override fun observer() {}

    override fun init() {}

    override fun initCtrl() {
        binding.nextBtn.setOnClickListener(this)
        binding.btnRegister.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.nextBtn.id -> {
                findNavController().navigate(R.id.action_welcomeFragment_to_loginFragment)

            }
            binding.btnRegister.id -> {
                findNavController().navigate(R.id.action_welcomeFragment_to_registerFragment)
            }
        }
    }

}