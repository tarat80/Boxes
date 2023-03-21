package com.example.boxes.boxesscreenfeature.domain

import com.example.boxes.boxesscreenfeature.presentation.BoxState

interface BoxesListRepository {

    suspend fun getBoxesByMail(mail : String) : BoxState
}