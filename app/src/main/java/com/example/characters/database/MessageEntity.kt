package com.example.characters.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "massage_table")
class MessageEntity(
     @PrimaryKey val id: Long,
     val name: String,
     val status: String,
     val species: String,
     val image: String
    )