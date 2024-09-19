package com.dushanesmith.moodycodingexercise.data.repository

import androidx.paging.PagingData
import com.dushanesmith.moodycodingexercise.data.model.Post
import kotlinx.coroutines.flow.Flow

interface PostRepository {

    fun getPostData(): Flow<PagingData<Post>>
}