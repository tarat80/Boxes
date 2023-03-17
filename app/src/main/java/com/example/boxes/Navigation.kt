package com.example.boxes

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun Navigation(navController: NavHostController,
               onNavigate: (Screen)->Unit ) {
    NavHost(navController = navController, startDestination = Screen.LoginScreen.route) {
        composable( route = Screen.LoginScreen.route) {
            LoginScreen(navController = navController, onNavigate )
        }
        composable( route = Screen.BoxesScreen.route +"/{name}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "Philipp"
                    nullable = true
                }
            )
        ) { entry ->
            BoxesScreen(name = entry.arguments?.getString("name"))
        }
    }
}

@Composable
fun LoginScreen( navController: NavController,
                 onNavigate: (Screen)->Unit) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(50.dp)
    ) {
        Button(onClick = {
            onNavigate(Screen.BoxesScreen)
            navController.navigate(Screen.BoxesScreen.withArgs("atAta"))
        }
        ) {
        }
    }
}

@Composable
fun BoxesScreen(
    name :String?
) {
    if (name != null) {
        Text(text = name)    }

}

@Composable
fun OneBoxScreen(


) {
}

@Composable
fun SettingsScreen(

) {
}

@Composable
fun AccountDetailsScreen(


) {
}