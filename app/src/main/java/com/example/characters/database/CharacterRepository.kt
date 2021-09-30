package com.example.characters.database

import com.example.characters.data.Charac
import com.example.characters.restApi.CharacterApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

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

    suspend fun addLesson(count: Long) {
        characterDao.addCharac(
            withContext(Dispatchers.IO) {
                characterApi.getCharacterList(count).results.map {
                    CharacterEntity(
                        id = it.id,
                        name = it.name,
                        status = it.status,
                        species = it.species,
                        image = it.image,
                        type = it.type,
                        gender = it.gender,
                        created = it.created
                    )
                }
            } as MutableList<CharacterEntity>
        )
    }

    suspend fun getNameList(name: String): List<Charac> =
        characterDao.getNameList(name).map {
            Charac(
                id = it.id,
                name = it.name,
                status = it.status,
                species = it.species,
                image = it.image,
                type = it.type,
                gender = it.gender,
                created = it.created
            )
        }

}