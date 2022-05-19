package com.inbyte.inbook.view.ui.authentication.login

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.inbyte.inbook.data.model.auth.request.LoginModel
import com.inbyte.inbook.databinding.FragmentLoginBinding
import com.inbyte.inbook.view.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>(), View.OnClickListener {

    val viewModel: LoginViewModel by viewModels()

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentLoginBinding.inflate(inflater, container, false)

    override fun observer() {}

    override fun init() {}

    override fun initCtrl() {
        binding.loginBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.loginBtn.id -> {
                val email = binding.emailTextFiled.editText?.text.toString()
                val password = binding.passwordTextFiled.editText?.text.toString()
                val validEmail = viewModel.checkEmail(email)
                val validPassword = viewModel.checkPassword(password)
                if (validPassword && validEmail) {
                    viewModel.getLoginResponse(LoginModel(email, password))
                    viewModel.loginResponse.observe(this) {
                        showBasicAlert(it)
                    }
                } else {
                    showBasicAlert("invalid Password or Email")
                }
            }
        }
    }


}