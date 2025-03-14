package com.example.hilttutorial.app.di

import com.example.hilttutorial.app.data.RepositoryImpl
import com.example.hilttutorial.app.data.SomeApi
import com.example.hilttutorial.app.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
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