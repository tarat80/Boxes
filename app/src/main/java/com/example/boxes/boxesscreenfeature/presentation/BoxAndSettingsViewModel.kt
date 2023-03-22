package com.example.boxes.boxesscreenfeature.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import javax.inject.Inject

class BoxAndSettingsViewModel @Inject constructor() {

    var boxStatTe by mutableStateOf(BoxState())
    private set
}