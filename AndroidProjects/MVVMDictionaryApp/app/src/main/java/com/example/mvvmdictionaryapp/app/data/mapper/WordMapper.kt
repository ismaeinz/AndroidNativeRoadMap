package com.example.mvvmdictionaryapp.app.data.mapper

import com.example.mvvmdictionaryapp.app.data.remote.dto.DefinitionDto
import com.example.mvvmdictionaryapp.app.data.remote.dto.MeaningDto
import com.example.mvvmdictionaryapp.app.data.remote.dto.WordItemDto
import com.example.mvvmdictionaryapp.app.domain.model.Definition
import com.example.mvvmdictionaryapp.app.domain.model.Meaning
import com.example.mvvmdictionaryapp.app.domain.model.WordItem


fun WordItemDto.toWordItem() = WordItem(
    word = word ?: "",
    meanings = meanings?.map {
        it.toMeaning()
    } ?: emptyList(),
    phonetic = phonetic ?: ""
)

fun MeaningDto.toMeaning() = Meaning(
    definition = definitionDtoToDefinition(definitions?.get(0)),
    partOfSpeech = partOfSpeech ?: ""
)


fun definitionDtoToDefinition(
    definitionDto: DefinitionDto?
) = Definition(
    definition = definitionDto?.definition ?: "",
    example = definitionDto?.example ?: ""
)













