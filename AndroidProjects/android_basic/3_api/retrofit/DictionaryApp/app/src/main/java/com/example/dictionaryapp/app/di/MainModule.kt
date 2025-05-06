package com.example.dictionaryapp.app.di

import com.example.dictionaryapp.app.data.api.DictionaryApiInterface
import com.example.dictionaryapp.app.data.api.DictionaryApiInterface.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object MainModule {
    @Provides
    @Singleton
    fun providesDictionaryApi(): DictionaryApiInterface {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(DictionaryApiInterface::class.java)
    }
}