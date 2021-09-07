package com.example.characters

import androidx.lifecycle.*
import com.example.characters.data.Charac
import com.example.characters.database.CharacterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainViewModel(
    private val cRepository: CharacterRepository
) : ViewModel() {

    val currencyLiveData: LiveData<List<Charac>> = cRepository.getCharacterList().asLiveData()
    val nameListLiveData: MutableLiveData<List<Charac>> = MutableLiveData()

    init {
        viewModelScope.launch {
            var count: Long = 1
            while (count < 34) {
                cRepository.addLesson(count)
                count++
            }
        }
    }
    fun getList(name: String) {
        viewModelScope.launch(Dispatchers.IO) {

            nameListLiveData.postValue(cRepository.getNameList(name))
        }

    }
}
