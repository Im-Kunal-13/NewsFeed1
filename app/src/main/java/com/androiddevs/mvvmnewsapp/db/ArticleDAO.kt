package com.androiddevs.mvvmnewsapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.androiddevs.mvvmnewsapp.data_models.Article

@Dao
interface ArticleDAO {
    // onConflict strategies determine what happens when the article we want to insert in our database is already present. In that case we simply want to replace that article.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(
        article: Article
    ): Long // This returns a long which is basically the id which was inserted.

    // Here we inserted an SQL Query.
    @Query(value = "SELECT * FROM articles")
    // This time it won't be a function because this will return a livedata object which doesn't work with coroutines.
    //* ViewModel is not recreated when we rotate our device.
    fun getAllArticles(): LiveData<List<Article>>

    @Delete
    suspend fun deleteArticle(
        article: Article
    )
}