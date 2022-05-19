package com.inbyte.inbook.data.error.errorUsecase

import com.inbyte.inbook.data.error.Error
import com.inbyte.inbook.data.error.mapper.ErrorMapper

class ErrorManager(private val errorMapper: ErrorMapper) : ErrorUseCase {
    override fun getError(errorCode: Int): Error {
        return Error(code = errorCode, description = errorMapper.errorsMap.getValue(errorCode))
    }
}