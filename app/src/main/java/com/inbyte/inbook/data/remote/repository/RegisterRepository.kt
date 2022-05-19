package com.inbyte.inbook.data.remote.repository

import com.inbyte.inbook.data.model.ApiResult
import com.inbyte.inbook.data.model.auth.request.RegisterModel
import com.inbyte.inbook.data.model.auth.response.RegisterResponse

interface RegisterRepository {

    suspend fun register(input:RegisterModel):ApiResult<RegisterResponse>
}