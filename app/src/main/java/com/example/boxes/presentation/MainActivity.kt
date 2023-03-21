package com.example.boxes.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.boxes.ui.theme.BoxesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val mainViewModel : MainViewModel = hiltViewModel()
            BoxesTheme {
                val navController = rememberNavController()
            Scaffold(topBar = { TopBar(mainViewModel.state.route) }
            ) {
                Box(Modifier.padding(it)) {
                    Navigation(navController, mainViewModel::onNavigate)
                }
            }
        }
    }
    }
}
