package com.example.boxes

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable


@Composable
fun TopBar(
    string: String
) {
    TopAppBar() {
        Text(text = string)
          }
}