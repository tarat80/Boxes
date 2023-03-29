package com.example.boxes.boxesscreenfeature.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.boxes.boxesscreenfeature.data.BoxesRepository
import com.example.boxes.boxesscreenfeature.domain.model.Box
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BoxesViewModel @Inject constructor(
    private val boxesRepository: BoxesRepository
) : ViewModel() {

 var state by mutableStateOf<List<Box>>(emptyList())
    private set

    fun getBoxes(id: Long) {
        viewModelScope.launch {
           state = boxesRepository.getBoxes(id)
        }
    }
}