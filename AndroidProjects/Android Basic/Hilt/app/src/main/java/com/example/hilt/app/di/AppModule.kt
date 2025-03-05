package com.example.hilt.app.di

import com.example.hilt.app.data.RepositoryImpl
import com.example.hilt.app.data.SomeApi
import com.example.hilt.app.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
//بيحدد اللايف تايم بتاع الinstance
@InstallIn(SingletonComponent::class)


object AppModule {
    @Provides
    @Singleton //عشان استخدم نفس الinstance كل مره ولو ماستخدمتهاش هيديني انستانس مختلف كل مره
    fun provideApi(): SomeApi {
        return Retrofit.Builder()
            .baseUrl("")
            .build()
            .create(SomeApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(api: SomeApi): Repository {
        return RepositoryImpl(api)
    }
}