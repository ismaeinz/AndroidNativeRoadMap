package com.example.hilttutorial.app.presention

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hilttutorial.app.domain.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.makeAPICall()
        }
    }
}