package com.inbyte.inbook.repo

import com.inbyte.inbook.api.ApiHelper
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val apiHelper: ApiHelper
) {
    suspend fun getPosts() = apiHelper.getPosts()
}