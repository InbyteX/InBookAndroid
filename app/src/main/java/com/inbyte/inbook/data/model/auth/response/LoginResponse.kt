package com.inbyte.inbook.data.model.auth.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("message"    ) var message    : String?     = null,
    @SerializedName("id"         ) var id         : Int?        = null,
    @SerializedName("user"       ) var user       : String?     = null,
    @SerializedName("role"       ) var role       : String?     = null,
    @SerializedName("adminModel" ) var adminModel : AdminModel? = AdminModel()
){
    data class AdminModel(
        @SerializedName("id"    ) var id    : Int?    = null,
        @SerializedName("user"  ) var user  : String? = null,
        @SerializedName("email" ) var email : String? = null,
        @SerializedName("role"  ) var role  : String? = null
    )
}
