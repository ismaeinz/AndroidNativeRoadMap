package com.example.mvvmdictionaryapp.app.data.remote.dto

data class MeaningDto(
    val definitions: List<DefinitionDto>? = null,
    val partOfSpeech: String? = null
)