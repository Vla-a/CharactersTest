package com.example.schoolorgonizer.lessonSchedule.daySchedule

import androidx.lifecycle.*
import com.example.characters.data.Charac
import com.example.characters.database.CharacterEntity
import com.example.myhomework.homework16.database.CharacterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DayScheduleViewModel(

    private val characRepository: CharacterRepository
) : ViewModel() {


    val liveData: LiveData<List<Charac>> =
        characRepository.getCharacterList().asLiveData()






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

        val newCharac = CharacterEntity(  name, id, status, species, image,type,gender,created)

        viewModelScope.launch {
            characRepository.addLesson(newCharac)
        }
    }
    }
