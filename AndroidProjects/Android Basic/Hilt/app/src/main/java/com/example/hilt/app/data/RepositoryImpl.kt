package com.example.hilt.app.data

import com.example.hilt.app.domain.repository.Repository

class RepositoryImpl(private val api: SomeApi) : Repository {

    override suspend fun makeAPICall() {
        println("Make Api Call")
        api.callApi()
    }
}