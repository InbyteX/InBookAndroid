package com.inbyte.inbook.view.ui.authentication.login

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.inbyte.inbook.data.model.ApiError
import com.inbyte.inbook.data.model.ApiResult
import com.inbyte.inbook.data.model.auth.request.LoginModel
import com.inbyte.inbook.data.model.auth.response.LoginResponse
import com.inbyte.inbook.data.remote.repository.LoginRepository
import com.inbyte.inbook.utils.common.Utils
import com.inbyte.inbook.view.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginRepository: LoginRepository,
    app: Application
) : BaseViewModel(app) {


    private val result = MutableLiveData<String>()
    val loginResponse: LiveData<String> = result


    fun checkEmail(email: String): Boolean {
        return Utils.isEmailValid(email)
    }

    fun checkPassword(password: String): Boolean {
        return Utils.isPasswordValid(password)
    }

    private fun loginApi(data: LoginModel): kotlinx.coroutines.flow.Flow<ApiResult<LoginResponse>> {
        return flow {
            try {
                emit(ApiResult.loading())
                val result = loginRepository.loginApi(data)
                emit(result)
            } catch (e: HttpException) {
                emit(ApiResult.error("Http Error", null))
            } catch (e: IOException) {
                emit(ApiResult.error("Exception", null))
            }
        }
    }

    fun getLoginResponse(data: LoginModel) {
        viewModelScope.launch {
            loginApi(data).collectLatest {
                when (it.status) {
                    ApiResult.Status.SUCCESS -> {
                        result.value = it.data?.message ?: "Something Went Wong"
                    }
                    ApiResult.Status.ERROR -> {
                        result.value = it.message ?: "Something Went Wong"
                    }
                    ApiResult.Status.LOADING -> {
                        // loader visibility
                    }
                }
            }
        }
    }

}