package com.dushanesmith.moodycodingexercise.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.dushanesmith.moodycodingexercise.data.model.Card
import com.dushanesmith.moodycodingexercise.data.model.api.remote.PostApi

/*
Paging3 paging source used to retrieve the card data and paginate
 */
class CardPagingSource(
    private val postApi: PostApi
) : PagingSource<Int, Card>() {
    override fun getRefreshKey(state: PagingState<Int, Card>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Card> {
        return try {
            val cardsResponse = postApi.getPostData().page.cards

            return LoadResult.Page(
                data = cardsResponse,
                nextKey = null,
                prevKey = null
            )
        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(
                throwable = e
            )
        }
    }
}