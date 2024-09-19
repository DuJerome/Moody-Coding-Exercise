package com.dushanesmith.moodycodingexercise.viewmodel

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.dushanesmith.moodycodingexercise.data.model.Card
import com.dushanesmith.moodycodingexercise.data.model.Post
import com.dushanesmith.moodycodingexercise.data.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val postRepository: PostRepository
): ViewModel() {
    fun getCardData(): Flow<PagingData<Card>> {
        return postRepository.getCardData()
    }
}