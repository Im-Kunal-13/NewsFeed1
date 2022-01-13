package com.androiddevs.mvvmnewsapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androiddevs.mvvmnewsapp.data_models.NewsResponseData
import com.androiddevs.mvvmnewsapp.repository.NewsRepository
import com.androiddevs.mvvmnewsapp.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class NewsViewModel(
    val newsRepository: NewsRepository
) : ViewModel() {
    val breakingNews: MutableLiveData<Resource<NewsResponseData>> = MutableLiveData()
    val breakingNewsPage: Int = 1

init {
    getBreakingNews(
      countryCode = "in"
    )
}

    fun getBreakingNews(
        countryCode: String
    ) = viewModelScope.launch {
        breakingNews.postValue(Resource.Loading())

        // Making the api call here.
        val response = newsRepository.getBreakingNews(
            countryCode,
            breakingNewsPage
        )

        // Posting the response we get from the api call.
        breakingNews.postValue(handleBreakingNewsResponse(response = response))
    }

    private fun handleBreakingNewsResponse(response: Response<NewsResponseData>): Resource<NewsResponseData> {
        if (response.isSuccessful) {
            response.body()?.let { responseResult ->
                return Resource.Success(data = responseResult)
            }
        }
        return Resource.Error(message = response.message())
    }
}