package com.example.hilt.app.domain.repository

interface Repository {
    suspend fun makeAPICall()
}