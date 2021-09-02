package com.example.myhomework.homework16.database

import com.example.characters.data.Charac
import com.example.characters.database.CharacterDao
import com.example.characters.database.CharacterEntity
import com.example.characters.restApi.CharacterApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CharacterRepository(
    private val characterDao: CharacterDao,
    private val characterApi: CharacterApi
) {
    fun getCharacterList(): Flow<List<Charac>> =
        characterDao.getCharacterList().map { characterEntity ->
            characterEntity.map {
                Charac(it.id, it.name, it.status, it.species, it.image, it.type, it.gender, it.created)
            }
        }


    suspend fun addLesson(charac: CharacterEntity) {
        characterDao.addCharac(charac)

    }

}