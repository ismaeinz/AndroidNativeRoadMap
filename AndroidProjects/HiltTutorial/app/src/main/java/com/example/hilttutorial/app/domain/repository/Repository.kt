package com.example.hilttutorial.app.domain.repository

interface Repository {
    suspend fun makeAPICall()
}