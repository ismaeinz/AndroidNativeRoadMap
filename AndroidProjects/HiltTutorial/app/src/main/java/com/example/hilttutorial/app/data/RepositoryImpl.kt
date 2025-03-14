package com.example.hilttutorial.app.data

import com.example.hilttutorial.app.domain.repository.Repository

class RepositoryImpl(
    private val api: SomeApi
) : Repository {
    override suspend fun makeAPICall() {
        println("make api call")
        api.callApi()
    }
}