package com.inbyte.inbook.view.ui.authentication.register

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.inbyte.inbook.data.model.auth.request.CompanyModel
import com.inbyte.inbook.databinding.FragmentRegisterBinding
import com.inbyte.inbook.view.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RegisterFragment : BaseFragment<FragmentRegisterBinding>(), View.OnClickListener {

    private val viewModel: RegisterViewModel by viewModels()

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentRegisterBinding.inflate(inflater, container, false)


    override fun init() {}

    override fun initCtrl() {
        binding.nextBtn.setOnClickListener(this)
    }

    override fun observer() {}

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.nextBtn.id -> {
                val companyName = binding.companyNameTextInput.editText?.text.toString()
                val companyType = binding.companyTypeTextInput.editText?.text.toString()
                if (companyName.isNotBlank() && companyType.isNotBlank()) {
                    val companyDetails = CompanyModel(companyName, companyType)
                    val action =
                        RegisterFragmentDirections.actionRegisterFragmentToUserRegisterFragment(
                            companyDetails
                        )
                    findNavController().navigate(action)
                }
            }
        }
    }

}