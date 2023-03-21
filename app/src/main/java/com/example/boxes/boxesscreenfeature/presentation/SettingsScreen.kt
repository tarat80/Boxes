package com.example.boxes.presentation

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun SettingsScreen(
    mail :String?
) {
    if (mail != null) {
        Text(text = mail)
    }
}