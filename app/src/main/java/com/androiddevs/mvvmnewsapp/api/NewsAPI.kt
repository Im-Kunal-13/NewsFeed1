package com.androiddevs.mvvmnewsapp.api

import com.androiddevs.mvvmnewsapp.data_models.NewsResponseData
import com.androiddevs.mvvmnewsapp.util.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {

    @GET(value = "v2/top-headlines")
    // To make the below function execute in a coroutine, we need to make it a suspend function.
    // note
    suspend fun getBreakingNews(
        @Query(value = "country")
        countryCode: String = "us",
        @Query(value = "page") //  note
        pageNumber: Int = 1,
        @Query(value = "apiKey")
        apiKey: String = API_KEY
    ): Response<NewsResponseData>

    @GET(value = "v2/everything")
    // To make the below function execute in a coroutine, we need to make it a suspend function.
    // note
    suspend fun searchForNews(
        @Query(value = "q")
        search: String,
        @Query(value = "page") //  note
        pageNumber: Int = 1,
        @Query(value = "apiKey")
        apiKey: String = API_KEY
    ): Response<NewsResponseData>
}