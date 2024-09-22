package com.dushanesmith.moodycodingexercise.data.model.api.remote

import com.dushanesmith.moodycodingexercise.data.model.Post
import retrofit2.http.GET

/*
Api Web Service Interface of post data
 */
interface PostApi {

    @GET("home")
    suspend fun getPostData(): Post
}