package com.inbyte.inbook.utils.response

import android.text.TextUtils
import com.google.gson.Gson
import com.inbyte.inbook.data.error.errorUsecase.ErrorManager
import com.inbyte.inbook.data.remote.NoConnectivityException
import com.inbyte.inbook.utils.common.Constants
import com.inbyte.inbook.data.model.ErrorResponseModel
import retrofit2.Response
import java.lang.Exception
import java.net.SocketTimeoutException

object ResponseHandler {

    fun <T> success(response: Response<T>?, errorManager: ErrorManager? = null): Resource<T?> {
        return if (response?.isSuccessful == true) {
            Resource.Success(response.body())
        } else {
            try {
                val data = response?.errorBody()?.string()
                val errorResponse = Gson().fromJson(
                    response?.errorBody()?.string(),
                    ErrorResponseModel::class.java
                )
                if (TextUtils.isEmpty(errorResponse.message)) {
                    return Resource.DataError(errorResponse.exception)
                }
                return Resource.DataError(errorResponse.message)
            } catch (e: Exception) {
                return Resource.DataError(e.message)

            }
        }
    }

    fun <T> failure(e: Exception?): Resource<T?> {
        if (e is NoConnectivityException) {
            return Resource.DataError(e.message)
        } else if (e is SocketTimeoutException) {
            return Resource.DataError("timed out")
        }
        return Resource.DataError(e?.message)
    }
}