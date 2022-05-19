package com.inbyte.inbook.data.model

data class ErrorResponseModel(
    val error: String?,
    val exception: String?,
    val message: String?,
    val status: Int?,
    val errorCode: Int?,
    val timestamp: String?
)