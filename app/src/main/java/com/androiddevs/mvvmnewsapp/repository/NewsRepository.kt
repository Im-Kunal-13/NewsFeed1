package com.androiddevs.mvvmnewsapp.repository

import com.androiddevs.mvvmnewsapp.api.RetrofitInstance
import com.androiddevs.mvvmnewsapp.db.ArticleDatabase


// This will lead to the creation of the database here.
// The purpose of this repository is to get data from our database and our remote data source.
// We will have a function that directly queries our api for our breaking news.
class NewsRepository(
    val db: ArticleDatabase
) {
    // In this function we called the getBreakingNews() function from the RetrofitInstance.api and assign it to it. why?
    suspend fun getBreakingNews(
        countryCode: String, pageNumber: Int
    ) = RetrofitInstance.api.getBreakingNews(
        countryCode,
        pageNumber
    )
}