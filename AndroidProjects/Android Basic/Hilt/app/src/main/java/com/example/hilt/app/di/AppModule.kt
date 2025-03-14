package com.example.hilt.app.di

import com.example.hilt.app.data.RepositoryImpl
import com.example.hilt.app.data.SomeApi
import com.example.hilt.app.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) //لايف تايم
object AppModule {
    @Provides
    @Singleton //عشان توفر ليا نفس الانستانس
    fun provideApi(): SomeApi {
        return Retrofit.Builder()
            .baseUrl("")
//            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SomeApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(api: SomeApi): Repository {
        return RepositoryImpl(api)
    }
}