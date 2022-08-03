package com.example.characters.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [CharacterEntity::class], version = 1)
abstract class CharacterDatabase : RoomDatabase() {

    abstract fun CharacterDao(): CharacterDao


    companion object {
        @Volatile
        private var instance: CharacterDatabase? = null

        fun getDatabase(context: Context): CharacterDatabase =
            instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also {
                    instance = it
                }
            }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, CharacterDatabase::class.java, "character_database")
                .fallbackToDestructiveMigration()
                .build()
    }
}