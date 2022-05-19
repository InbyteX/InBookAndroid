package com.inbyte.inbook.data.remote.api

import com.inbyte.inbook.data.model.ApiError
import com.inbyte.inbook.data.model.auth.request.LoginModel
import com.inbyte.inbook.data.model.auth.request.RegisterModel
import com.inbyte.inbook.data.model.auth.response.LoginResponse
import com.inbyte.inbook.data.model.auth.response.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {

    @POST("login")
    suspend fun getLogin(
        @Header("company") companyName:String,
        @Body input: LoginModel
    ):Response<LoginResponse>

    @POST("company/register")
    suspend fun getRegister(
        @Body input: RegisterModel
    ):Response<RegisterResponse>
}