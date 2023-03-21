package com.example.boxes.boxesscreenfeature.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.boxes.boxesscreenfeature.domain.model.Box
import javax.inject.Inject

class BoxAndSettingsViewModel @Inject constructor() {

    var boxStatle by mutableStateOf(BoxState())
    private set
}