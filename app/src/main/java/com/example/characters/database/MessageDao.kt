package com.example.characters.database


import androidx.room.*
import com.example.characters.data.Character

@Dao
interface MessageDao {

//    @Query("SELECT * FROM massage_table")
//    fun getMessageList(date: Character): List<MessageEntity>
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun addMessage(message: MessageEntity)
//
//    @Delete
//    suspend fun deleteMessage(message: MessageEntity)
}