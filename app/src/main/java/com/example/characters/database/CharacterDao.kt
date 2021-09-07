package com.example.characters.database


import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterDao {

    @Query("SELECT * FROM character_table")
    fun getCharacterList(): Flow<List<CharacterEntity>>

    @Query("SELECT * FROM character_table WHERE name LIKE :name ORDER BY id")
    suspend fun getNameList(name: String): List<CharacterEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCharac(character: MutableList<CharacterEntity>)


}