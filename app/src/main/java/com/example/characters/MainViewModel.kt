package com.example.characters

import android.util.Log
import androidx.lifecycle.*
import com.example.characters.data.Charac
import com.example.characters.data.Character
import com.example.characters.database.CharacterEntity
import com.example.characters.restApi.ApiRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


class MainViewModel (
    private val cRepository: ApiRepository
) : ViewModel() {

    val currencyLiveData: MutableLiveData<MutableList<Character>> = MutableLiveData()

    init {
        viewModelScope.launch {
            currencyLiveData.value = cRepository.getCharacterList(" ", 1)
            Log.e("KEK", cRepository.getCharacterList().toString())
        }

    }

    fun addCount( name: String, page: Long) {
        viewModelScope.launch(Dispatchers.Main) {
            val cList =
                cRepository.getCharacterList(name, page)
            currencyLiveData.value = cList
        }
    }


    fun addMessageToDatabase(
        id: Long,
        name: String,
        status: String,
        species: String,
        image: String,
        type: String,
        gender: String,
        created: String
    ) {
        val newCharac = Character(name,id , status, species, image,type,gender,created)

        viewModelScope.launch {
            cRepository.addLesson(newCharac)
        }
    }

}
