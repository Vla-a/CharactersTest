package com.example.characters.di

import android.content.Context
import com.example.characters.database.CharacterDao
import com.example.characters.database.CharacterDatabase
import com.example.characters.repository.CharacterRepository
import com.example.characters.restApi.CharacterApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson) : Retrofit = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/api/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(
            OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }).build()
        )
        .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideCharacterService(retrofit: Retrofit): CharacterApi = retrofit.create(CharacterApi::class.java)

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) = CharacterDatabase.getDatabase(appContext)

    @Singleton
    @Provides
    fun provideCharacterDao(db: CharacterDatabase) = db.CharacterDao()


    @Provides
    fun provideRepository(remoteDataSource: CharacterApi,
                          localDataSource: CharacterDao
    ) =  CharacterRepository(localDataSource, remoteDataSource)
}