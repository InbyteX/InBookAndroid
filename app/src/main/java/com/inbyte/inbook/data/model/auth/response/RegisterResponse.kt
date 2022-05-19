package com.inbyte.inbook.data.model.auth.response

data class RegisterResponse(
    val companyName: String,
    val companyType: String,
    val id: Int,
    val userModel: List<UserModel>
)