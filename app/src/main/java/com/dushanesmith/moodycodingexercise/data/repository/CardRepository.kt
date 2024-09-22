package com.dushanesmith.moodycodingexercise.data.repository

import androidx.paging.PagingData
import com.dushanesmith.moodycodingexercise.data.model.Card
import kotlinx.coroutines.flow.Flow

interface CardRepository {

    /*
    Retrieves card data from the api webservice
     */
    fun getCardData(): Flow<PagingData<Card>>
}