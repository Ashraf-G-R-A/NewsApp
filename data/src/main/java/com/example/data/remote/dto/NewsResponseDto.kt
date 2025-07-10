package com.example.data.remote.dto

data class NewsResponseDto(
    val articles: List<ArticleDto>
)

data class ArticleDto(
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String?
)
