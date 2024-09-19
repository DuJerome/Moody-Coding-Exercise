package com.dushanesmith.moodycodingexercise.data.repository

import androidx.paging.PagingData
import com.dushanesmith.moodycodingexercise.data.model.Card
import kotlinx.coroutines.flow.Flow

interface PostRepository {

    fun getCardData(): Flow<PagingData<Card>>
}