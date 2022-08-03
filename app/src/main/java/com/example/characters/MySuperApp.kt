package com.example.characters

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class MySuperApp : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
//    override fun onCreate() {
//        super.onCreate()
//        startKoin {
//            androidContext(this@MySuperApp)
//            modules(listOf(repositoryModule, viewModels, currencyApi, storageModule))
//        }
//    }
//
//    private val viewModels = module {
//        viewModel { MainViewModel(get()) }
//
//    }
//
//    private val repositoryModule = module {  //создаем репозитории
//
//        factory { CharacterRepository(get(),get()) }
//    }
//
//    private val currencyApi = module {
//        single { CharacterApi.get() }
//    }
//
//    private val storageModule = module {
//        single { DatabaseConstructor.create(get()) }  //создаем синглтон базы данных
//        factory { get<CharacterDatabase>().CharacterDao() } //предоставляем доступ для конкретной Dao (в нашем случае NotesDao)
//
//    }

}