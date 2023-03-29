package com.example.boxes.boxesscreenfeature.data

import com.example.boxes.boxesscreenfeature.domain.model.Box

interface BoxesRepository {

    suspend fun getBoxes(id : Long) : List<Box>

}