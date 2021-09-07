package com.example.characters.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "character_table", primaryKeys = ["id", "name"])
class CharacterEntity(
    val name: String,
    val id: Long,
    val status: String,
    val species: String,
    val image: String,
    val type: String,
    val gender: String,
    val created: String
)