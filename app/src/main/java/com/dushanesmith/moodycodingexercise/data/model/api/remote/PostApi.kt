package com.dushanesmith.moodycodingexercise.data.model.api.remote

import com.dushanesmith.moodycodingexercise.data.model.Post
import retrofit2.http.GET

interface PostApi {

    @GET("test/home")
    suspend fun getPostData(): List<Post>
}