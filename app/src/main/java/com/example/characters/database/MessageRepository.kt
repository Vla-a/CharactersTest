package com.example.myhomework.homework16.database

import com.example.characters.data.Character
import com.example.characters.database.MessageDao
import com.example.characters.database.MessageEntity

class MessageRepository(
    private val messageDao: MessageDao
) {
//    suspend fun getMessagesList(date: Character): List<Character> =
//        messageDao.getMessageList(date).map {
//            Character(it.id, it.name, it.status, it.species, it.image)
//        }
//
//    suspend fun addMessages(message: MessageEntity) {
//        messageDao.addMessage(message)
//
//    }
//
//    suspend fun deleteMessage(message: Character) {
//
//        messageDao.deleteMessage(message.entity())
//    }
//
//    private fun Character.entity() = MessageEntity(
//        this.id,
//        this.name,
//        this.status,
//        this.species,
//        this.image
//          )
}