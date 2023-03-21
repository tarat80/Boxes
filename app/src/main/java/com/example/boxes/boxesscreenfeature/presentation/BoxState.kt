package com.example.boxes.boxesscreenfeature.presentation

import com.example.boxes.boxesscreenfeature.domain.model.Box

data class BoxState(
    val mail: String =" ",
    val boxes : List<Box> = listOf(Box(), Box(), Box(), Box(), Box(), Box())
)