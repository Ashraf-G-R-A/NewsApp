package com.example.domain.news.repo

import androidx.paging.PagingData
import com.example.domain.news.model.NewsEntity
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getNewsByQueryPaging(
        query: String,
        from: String,
        to: String,
        pageSize: Int = 20
    ): Flow<PagingData<NewsEntity>>
}
