package com.dushanesmith.moodycodingexercise.data.repository

import androidx.paging.PagingData
import com.dushanesmith.moodycodingexercise.data.model.Post
import com.dushanesmith.moodycodingexercise.data.model.api.remote.PostApi
import kotlinx.coroutines.flow.Flow

class PostRepositoryImpl(private val postApi: PostApi) : PostRepository {
    override fun getPostData(): Flow<PagingData<Post>> {
        TODO("Not yet implemented")
    }
}