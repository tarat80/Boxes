package com.example.boxes.presentation

import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.boxes.boxesscreenfeature.presentation.BoxesScreen
import com.example.boxes.loginfeature.presentation.LoginScreen

@Composable
fun Navigation(navController: NavHostController,
               onNavigate: (Screen)->Unit

) {
    NavHost(navController = navController,
        startDestination = Screen.LoginScreen.route) {

        composable( route = Screen.LoginScreen.route) {
            LoginScreen(navController = navController,
                 onNavigate = onNavigate )
        }

        composable( route = Screen.BoxesScreen.route +"/{mail}",
            arguments = listOf(
                navArgument("mail") {
                    type = NavType.StringType
                    defaultValue = "mail"
                    nullable = false
                }
            )
        ) { entry ->   BoxesScreen(mail = entry.arguments?.getString("mail")) }

        composable( route = Screen.OneBoxScreen.route,
            ) { OneBoxScreen()  }

        composable( route = Screen.SettingsScreen.route +"/{mail}",
            arguments = listOf(
                navArgument("mail") {
                    type = NavType.StringType
                    defaultValue = "mail"
                    nullable = false
                }
            )
        ) {  entry -> SettingsScreen(mail = entry.arguments?.getString("mail"))  }

        composable( route = Screen.AccountDetailsScreen.route,
        ) {  AccountDetailsScreen()  }
    }
}


@Composable
fun OneBoxScreen(


) {
}

@Composable
fun AccountDetailsScreen(


) {
}