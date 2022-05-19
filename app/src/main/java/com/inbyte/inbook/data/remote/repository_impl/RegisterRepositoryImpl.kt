package com.inbyte.inbook.data.remote.repository_impl

import com.inbyte.inbook.data.model.ApiResult
import com.inbyte.inbook.data.model.auth.request.RegisterModel
import com.inbyte.inbook.data.model.auth.response.RegisterResponse
import com.inbyte.inbook.data.remote.api.ApiService
import com.inbyte.inbook.data.remote.repository.RegisterRepository
import com.inbyte.inbook.utils.response.RetrofitUtlis
import javax.inject.Inject

class RegisterRepositoryImpl @Inject constructor(private val apiService: ApiService) :
    RegisterRepository {
    override suspend fun register(input: RegisterModel): ApiResult<RegisterResponse> {
        return RetrofitUtlis.getResponse(
            {
                apiService.getRegister(input)
            }, "something went Wrong"
        )

    }
}