package com.inbyte.inbook.data.model.auth.response

data class UserModel(
    val email: String,
    val id: Int,
    val role: String,
    val user: String
)