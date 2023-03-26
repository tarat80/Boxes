package com.example.boxes.boxesscreenfeature.presentation

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun BoxesScreen(
    navController: NavHostController,
    id: Int?
) {
   if (id != null) {
      Text(text = id.toString())
   }
}