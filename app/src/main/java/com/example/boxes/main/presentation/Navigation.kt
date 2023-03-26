package com.example.boxes.main.presentation

import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.boxes.boxesscreenfeature.presentation.BoxesScreen
import com.example.boxes.loginfeature.presentation.LoginScreen
import com.example.boxes.loginfeature.presentation.LoginViewModel
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
            val vm : LoginViewModel = hiltViewModel()
            LoginScreen(navController = navController, vm)
        }
        composable(route = Screen.RegisterScreen.route) {
            RegisterScreen(navController = navController)
        }
        composable(route = Screen.BoxesScreen.route + "/{id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                    defaultValue = -1
                }
            )
        ) { entry -> BoxesScreen(
            navController = navController,
            id = entry.arguments?.getInt("id")) }
/*
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



