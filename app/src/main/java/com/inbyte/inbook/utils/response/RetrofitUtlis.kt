package com.inbyte.inbook.utils.response

import com.inbyte.inbook.data.model.ApiError
import com.inbyte.inbook.data.model.ApiResult
import com.inbyte.inbook.data.remote.EnvironmentConfig
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

object RetrofitUtlis {
    suspend fun <T> getResponse(
        request: suspend () -> Response<T>,
        defaultErrorMessage: String
    ): ApiResult<T> {
        return try {
            val result = request.invoke()
            if (result.isSuccessful) {
                return ApiResult.success(result.body())
            } else {
                val errorResponse = parseError(result)
                ApiResult.error(errorResponse?.message?:defaultErrorMessage,errorResponse)
            }
        } catch (e: Throwable) {
            e.printStackTrace()
            ApiResult.error("Unknown Error", null)
        }
    }

    private fun parseError(response: Response<*>): ApiError? {
        // Just error parsing
        val retrofit = Retrofit.Builder()
            .baseUrl(EnvironmentConfig.getInBookURl())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val converter = retrofit.responseBodyConverter<ApiError>(ApiError::class.java, arrayOfNulls(0))
        return try {
            converter.convert(response.errorBody()!!)
        } catch (e: IOException) {
            ApiError()
        }
    }
}