package com.dushanesmith.moodycodingexercise.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.dushanesmith.moodycodingexercise.data.CardPagingSource
import com.dushanesmith.moodycodingexercise.data.model.Card
import com.dushanesmith.moodycodingexercise.data.model.Post
import com.dushanesmith.moodycodingexercise.data.model.api.remote.PostApi
import kotlinx.coroutines.flow.Flow

class PostRepositoryImpl(private val postApi: PostApi) : PostRepository {
    override fun getCardData(): Flow<PagingData<Card>> {
        return Pager(
            config = PagingConfig(10),
            pagingSourceFactory = { CardPagingSource(postApi) }
        ).flow
    }
}