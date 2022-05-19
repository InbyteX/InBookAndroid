package com.inbyte.inbook.data.model.auth.request

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CompanyModel(
    val companyName: String = "",
    val companyType: String = ""
) : Parcelable