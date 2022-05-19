package com.inbyte.inbook.data.model.auth.request

import com.google.gson.annotations.SerializedName

data class RegisterModel(
    @SerializedName("companyName" ) var companyName : String?              = null,
    @SerializedName("companyType" ) var companyType : String?              = null,
    @SerializedName("userModel"   ) var userModel   : ArrayList<UserModel> = arrayListOf()
){
    data class UserModel(
        @SerializedName("user"     ) var user     : String? = null,
        @SerializedName("email"    ) var email    : String? = null,
        @SerializedName("password" ) var password : String? = null,
        @SerializedName("role"     ) var role     : String? = null
    )
}
