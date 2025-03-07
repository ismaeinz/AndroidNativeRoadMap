package com.example.movieapp.app.common

interface ApiMapper<Domain, Entity> {
    fun mapToDomain(apiDto: Entity): Domain

}