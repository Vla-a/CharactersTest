package com.example.characters.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [MessageEntity::class], version = 1)
abstract class MessageDatabase : RoomDatabase() {

    abstract fun MessageDao(): MessageDao
}

object DatabaseConstructor {
    fun create(context: Context): MessageDatabase =
        Room.databaseBuilder(
            context,
            MessageDatabase::class.java,
            "message_database"
        ).build()
}