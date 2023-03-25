package com.example.boxes.main.presentation

import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.boxes.loginfeature.presentation.LoginScreen
import com.example.boxes.registerfeature.presentation.RegisterScreen


@Composable
fun Navigation(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.LoginScreen.route
    ) {

        composable(route = Screen.LoginScreen.route) {
            LoginScreen(navController = navController)
        }
        composable(route = Screen.RegisterScreen.route) {
            RegisterScreen(navController = navController)
        }

        /*   composable( route = Screen.BoxesScreen.route +"/{mail}",
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
           ) {  AccountDetailsScreen()  }*/
    }
}



