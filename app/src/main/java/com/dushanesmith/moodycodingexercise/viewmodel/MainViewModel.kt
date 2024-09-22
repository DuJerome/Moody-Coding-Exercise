package com.dushanesmith.moodycodingexercise.viewmodel

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.dushanesmith.moodycodingexercise.data.model.Card
import com.dushanesmith.moodycodingexercise.data.repository.CardRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val cardRepository: CardRepository
): ViewModel() {
    /*
    retrieves card data from the repository
     */
    fun getCardData(): Flow<PagingData<Card>> {
        return cardRepository.getCardData()
    }
}