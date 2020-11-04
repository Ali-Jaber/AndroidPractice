package com.android.practice.practice.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Post::class], version = 2, exportSchema = false)
abstract class PostsDatabase : RoomDatabase() {
    abstract fun postDao(): PostsDao

    object DatabaseBuilder {
        private var INSTANCE: PostsDatabase? = null

        fun getDatabase(context: Context): PostsDatabase {
            if (INSTANCE == null) {
                synchronized(PostsDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext, PostsDatabase::class.java,
                        "posts_database"
                    )
                        .build()
                }
            }
            return INSTANCE!!
        }
    }
}