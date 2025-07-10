package com.example.domain.news.usecase

import com.example.domain.news.repo.NewsRepository

class GetNewsByQueryUseCase(private val repository: NewsRepository) {
    suspend operator fun invoke(query: String, from: String, to: String) =
        repository.getNewsByQueryPaging(query, from, to)
}
