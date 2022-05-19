package com.inbyte.inbook.api

import com.inbyte.inbook.data.Post
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    suspend fun getPosts(): Response<List<Post>>

}