package com.example.characters.restApi

import com.example.characters.data.Character
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class ApiRepository(
    private val characterApi: CharacterApi
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

}

