package com.inbyte.inbook.data.model

import com.google.gson.annotations.SerializedName

data class EmptyApiResponse (
    @SerializedName("status") val status:Int,
    @SerializedName("message") val message:String
)
