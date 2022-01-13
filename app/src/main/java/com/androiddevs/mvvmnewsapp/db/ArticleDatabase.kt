package com.androiddevs.mvvmnewsapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.androiddevs.mvvmnewsapp.data_models.Article

// note -> Database classes for Room always need to be abstract.
@Database(
    entities = [Article::class],
    version = 1
)

@TypeConverters(
    Converters::class
)
abstract class ArticleDatabase : RoomDatabase() {

    abstract fun getArticleDao(): ArticleDAO

    companion object {
        // Marking this with @Volatile means that the other thread can immediately see or get notified when a thread changes this instance.
        @Volatile
        private var instance: ArticleDatabase? = null

        // We will use the log to synchronize setting this instance.
        private val LOCK = Any()

        //  Learn
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
// Implementing this block means that whenever this block of code gets executed, other threads can't perform any operation or access it.
            instance ?: createDatabase(context).also {
                instance = it
            }
        }

        // learn
        fun createDatabase(
            context: Context
        ) = Room.databaseBuilder(
            context.applicationContext,
            ArticleDatabase::class.java,
            "article_db.db"
        ).build()
    }
}