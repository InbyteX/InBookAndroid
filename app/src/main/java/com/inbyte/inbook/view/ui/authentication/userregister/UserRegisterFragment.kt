package com.inbyte.inbook.view.ui.authentication.userregister

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.inbyte.inbook.databinding.FragmentUserRegisterBinding
import com.inbyte.inbook.view.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class UserRegisterFragment : BaseFragment<FragmentUserRegisterBinding>(), View.OnClickListener {

    private val viewModel:UserRegisterViewModel by viewModels()
    private val args:UserRegisterFragmentArgs by navArgs()

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentUserRegisterBinding.inflate(inflater, container, false)

    override fun init() {
        // receive the args
        val companyDetails = args.companyDetails
        Log.i("company_details",companyDetails.toString())
    }

    override fun initCtrl() {
        binding.btnFinish.setOnClickListener(this)
    }

    override fun observer() {}
    override fun onClick(v: View?) {}

}