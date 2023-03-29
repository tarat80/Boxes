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
import com.example.boxes.registerfeature.presentation.RegisterViewModel


@Composable
fun Navigation(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.LoginScreen.route
    ) {

        composable(route = Screen.LoginScreen.route) {
            val lvm : LoginViewModel = hiltViewModel()
            LoginScreen(navController = navController, lvm)
        }
        composable(route = Screen.RegisterScreen.route) {
            val rvm : RegisterViewModel = hiltViewModel()
            RegisterScreen(navController = navController, rvm)
        }
        composable(route = Screen.BoxesScreen.route + "/{id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.LongType
                    defaultValue = -1
                    nullable = false
                }
            )
        ) { entry -> BoxesScreen(
            navController = navController,
            id = entry.arguments?.getLong("id")) }
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



