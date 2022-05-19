package com.inbyte.inbook.data.error.errorUsecase

import com.inbyte.inbook.data.error.Error

interface ErrorUseCase {
    fun getError(errorCode: Int): Error
}
