package com.example.boxes.boxesscreenfeature.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BoxesScreen(
   mail :String?="",

) {
Box(modifier = Modifier.fillMaxSize(),
Alignment.Center) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxSize(0.6f)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            ItemBox(Modifier.size(100.dp))
            ItemBox(Modifier.size(100.dp))
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            ItemBox(Modifier.size(100.dp))
            ItemBox(Modifier.size(100.dp))
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            ItemBox(Modifier.size(100.dp))
            ItemBox(Modifier.size(100.dp))
        }
    }
}


}