package com.example.characters

import android.app.Application
import com.example.characters.restApi.ApiRepository
import com.example.characters.restApi.CharacterApi
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MySuperApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MySuperApp)
            modules(listOf(repositoryModule, viewModels, currencyApi))
        }
    }

    private val viewModels = module {
        viewModel { MainViewModel(get()) }

    }

    private val repositoryModule = module {  //создаем репозитории
        factory { ApiRepository(get()) }

    }

    private val currencyApi = module {
        single { CharacterApi.get() }

    }

}