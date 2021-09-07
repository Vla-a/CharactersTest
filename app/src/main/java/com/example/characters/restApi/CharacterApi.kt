package com.example.characters.restApi

import com.example.characters.entities.CharacterResponce
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterApi {

    @GET("https://rickandmortyapi.com/api/character/?")
    suspend fun getCharacterList(
      @Query("page") page: Long
    ): CharacterResponce

    companion object {
        private const val BASE_URL = "https://rickandmortyapi.com"

        fun get(): CharacterApi = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    }).build()
            )
            .build().create(CharacterApi::class.java)
    }
}
