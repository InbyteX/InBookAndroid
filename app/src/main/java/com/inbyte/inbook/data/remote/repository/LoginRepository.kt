package com.inbyte.inbook.data.remote.repository


import com.inbyte.inbook.data.model.ApiError
import com.inbyte.inbook.data.model.ApiResult
import com.inbyte.inbook.data.model.auth.request.LoginModel
import com.inbyte.inbook.data.model.auth.response.LoginResponse

interface LoginRepository {
    //need to pass input data
    suspend fun loginApi(input: LoginModel): ApiResult<LoginResponse>
}