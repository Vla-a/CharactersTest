package com.example.characters

import android.app.Application
import com.example.characters.database.CharacterDatabase
import com.example.characters.database.CharacterRepository
import com.example.characters.database.DatabaseConstructor
import com.example.characters.restApi.CharacterApi
import com.example.characters.screen.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MySuperApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MySuperApp)
            modules(listOf(repositoryModule, viewModels, currencyApi, storageModule))
        }
    }

    private val viewModels = module {
        viewModel { MainViewModel(get()) }

    }

    private val repositoryModule = module {  //создаем репозитории

        factory { CharacterRepository(get(),get()) }
    }

    private val currencyApi = module {
        single { CharacterApi.get() }
    }

    private val storageModule = module {
        single { DatabaseConstructor.create(get()) }  //создаем синглтон базы данных
        factory { get<CharacterDatabase>().CharacterDao() } //предоставляем доступ для конкретной Dao (в нашем случае NotesDao)

    }

}