package com.example.characters

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.characters.data.Character
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

}
