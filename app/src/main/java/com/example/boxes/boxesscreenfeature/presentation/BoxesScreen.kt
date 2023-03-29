package com.example.boxes.boxesscreenfeature.presentation

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@Composable
fun BoxesScreen(
    navController: NavHostController,
    id: Long?,
    viewModel: BoxesViewModel = hiltViewModel()
) {
   val state = viewModel.state
    LaunchedEffect(key1 = true ){
    if (id != null)  viewModel.getBoxes(id)  
   }
    LazyColumn{
        items(state.size) {
            Text(text = state[it].toString())
        }
    }
}