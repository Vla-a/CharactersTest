package com.example.characters.restApi

import com.example.characters.data.Charac
import com.example.characters.data.Character
import com.example.characters.database.CharacterDao
import com.example.characters.database.CharacterEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext


class ApiRepository(
    private val characterApi: CharacterApi,
    private val characterDao: CharacterDao,
) {

    suspend fun getCharacterList(
        name: String = "",
        page: Long = 1
    ): MutableList<Character> {

        return withContext(Dispatchers.IO) {
            characterApi.getCharacterList(name,page).results.map {
                Character(
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
        } as MutableList<Character>
    }

    fun getCharacList(): Flow<List<Charac>> =
        characterDao.getCharacterList().map { characterEntity ->
            characterEntity.map {
                Charac(it.id, it.name, it.status, it.species, it.image, it.type, it.gender, it.created)
            }
        }


    suspend fun addLesson(character: Character) {


            characterDao.addCharac(character.entity())


    }
    private fun Character.entity() = CharacterEntity(this.name, this.id,
    this.status, this.species, this.image,this.type,this.gender, this.created)

}

