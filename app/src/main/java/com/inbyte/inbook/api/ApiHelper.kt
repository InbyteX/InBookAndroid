package com.inbyte.inbook.api

import com.inbyte.inbook.data.Post
import retrofit2.Response

interface ApiHelper {

    suspend fun getPosts(): Response<List<Post>>
}