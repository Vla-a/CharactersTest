package com.example.schoolorgonizer.lessonSchedule.daySchedule

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.characters.data.Character
import com.example.characters.database.MessageEntity
import com.example.myhomework.homework16.database.MessageRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DayScheduleViewModel(

    private val lessonRepository: MessageRepository
) : ViewModel() {


//    val lessonsListLiveData: MutableLiveData<List<Character>> = MutableLiveData()
//init {
//    fun getList(date: Character) {
//        viewModelScope.launch(Dispatchers.IO) {
//
//            lessonsListLiveData.postValue(lessonRepository.getMessagesList(date))
//        }
//
//    }
//}
//
//
//    fun addMessageToDatabase(
//        id: Long,
//         name: String,
//        status: String,
//         species: String
//        ) {
//
//        val newLesson = MessageEntity( id, name, status, species, status, )
//
//        viewModelScope.launch {
//            lessonRepository.addMessages(newLesson)
//        }
//    }
    }
