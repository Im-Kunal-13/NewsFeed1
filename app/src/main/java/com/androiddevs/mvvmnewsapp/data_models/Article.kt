package com.androiddevs.mvvmnewsapp.data_models

import androidx.room.Entity
import androidx.room.PrimaryKey

// Annotating the data class with @Entity will tell android studio that this data class will be used as a table in our room database.
@Entity(
    tableName = "articles"
)

data class Article(
    // annotating the id with @PrimaryKey will automatically increment the id and we don't have to handle that manually.
    @PrimaryKey(autoGenerate = true )
    var id: Int? = null,
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String
)