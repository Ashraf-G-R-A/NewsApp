package com.example.data.repo.news

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.data.mapper.toNewsEntity
import com.example.data.remote.api.NewsApiService
import com.example.domain.news.model.NewsEntity
import javax.inject.Named

class NewsPagingSource(
    private val api: NewsApiService,
    @Named("newsApiKey") private val apiKey: String,
    private val query: String,
    private val from: String,
    private val to: String,
    private val sortBy: String = "popularity"
) : PagingSource<Int, NewsEntity>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, NewsEntity> {
        val page = params.key ?: 1
        val pageSize = params.loadSize

        return try {
            val response = api.getEverything(
                query = query,
                from = from,
                to = to,
                sortBy = sortBy,
                page = page,
                pageSize = pageSize,
                apiKey = apiKey
            )
            val newsList = response.articles.map { it.toNewsEntity() }

            LoadResult.Page(
                data = newsList,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (newsList.isEmpty()) null else page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, NewsEntity>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val page = state.closestPageToPosition(anchorPosition)
            page?.prevKey?.plus(1) ?: page?.nextKey?.minus(1)
        }
    }
}
