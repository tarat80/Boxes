package com.example.boxes.main.presentation

sealed class Screen(val route: String) {
    object LoginScreen : Screen("login_screen")
    object RegisterScreen : Screen("register_screen")
    object BoxesScreen : Screen("boxes_screen")
    object OneBoxScreen : Screen("one_box_screen")
    object SettingsScreen : Screen("settings_screen")
    object AccountDetailsScreen : Screen("account_details_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg -> append("/$arg") }
        }
    }
}