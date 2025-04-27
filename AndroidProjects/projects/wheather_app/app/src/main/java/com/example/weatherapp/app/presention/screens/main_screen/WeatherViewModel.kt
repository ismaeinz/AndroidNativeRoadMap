package com.example.weatherapp.app.presention.screens.main_screen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.app.data.remote.ApiInstance
import com.example.weatherapp.app.data.remote.NetworkResponse
import com.example.weatherapp.app.data.model.WeatherModel
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {
    private val _weatherResult = MutableLiveData<NetworkResponse<WeatherModel>>()
    val weatherResult =
        _weatherResult


    fun getData(city: String) {
        viewModelScope.launch {

            try {
                val response =|
                ApiInstance.api.getWeather(
                    "2c737010a5ef434eb0883741250201", "Cairo"
                )
                if (
                    response.isSuccessful()) {
                    response.body()?.let {
                        _weatherResult.value = NetworkResponse.Success(it)
                    }
                } else {
                    _weatherResult.value = NetworkResponse.Error("Failed to load data")
                }

            } catch (e: Exception) {
                _weatherResult.value = NetworkResponse.Error("Failed to load data")

            }
        }

    }
}