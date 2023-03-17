package com.example.boxes

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
            val vm : MainViewModel = hiltViewModel()
            BoxesTheme {
                val navController = rememberNavController()
            Scaffold(topBar = { TopBar(vm.state.route) }
            ) {
                Box(Modifier.padding(it)) {
                    Navigation(navController, vm::onNavigate)
                }
            }
        }
    }
    }
}
