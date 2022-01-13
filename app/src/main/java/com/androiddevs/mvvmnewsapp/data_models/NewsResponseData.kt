package com.androiddevs.mvvmnewsapp.data_models

data class NewsResponseData(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)