package com.example.newsly.app.di

import com.example.newsly.app.data.remote.NewsApi
import com.example.newsly.app.data.remote.NewsApi.Companion.BASE_URL
import com.example.newsly.app.data.repositoryImpl.NewsRepositoryImpl
import com.example.newsly.app.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class) //createSingleObjectFor Application
object AppModule {
    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi {
        val retrofit =
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build()
        return retrofit.create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(newsApi: NewsApi): NewsRepository {
        return NewsRepositoryImpl(newsApi = newsApi)

    }
}