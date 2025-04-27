package com.example.day1.presention.screens.main_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.day1.data.remote.api.ApiServicesInstance
import com.example.day1.data.remote.responed.ResponedItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Collections.emptyList


class MainScreenViewModel : ViewModel() {
    private val _state = mutableStateOf<List<ResponedItem>>(emptyList())
    val state: State<List<ResponedItem>> = _state

    init {
        fetchData()

    }

    private fun fetchData() {
        viewModelScope.launch {
            _state.value = fetchCountriesFromApi()
        }
    }

    private suspend fun fetchCountriesFromApi(): List<ResponedItem> =
        withContext(Dispatchers.IO) {
            val getDataFromAPi =
                ApiServicesInstance.api.getAllCountries()
            return@withContext getDataFromAPi
        }

}