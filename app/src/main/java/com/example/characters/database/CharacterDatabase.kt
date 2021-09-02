package com.example.characters.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [CharacterEntity::class], version = 1)
abstract class CharacterDatabase : RoomDatabase() {

    abstract fun CharacterDao(): CharacterDao
}

object DatabaseConstructor {
    fun create(context: Context): CharacterDatabase =
        Room.databaseBuilder(
            context,
            CharacterDatabase::class.java,
            "character_database"
        ).build()
}