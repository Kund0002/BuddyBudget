package com.example.buddybudget

sealed class Screen(val route: String) {
    object MainScreen : Screen("main_screen")
    object LoginScreen : Screen("login_screen")
    object SplashScreen : Screen("splash_screen")
    object SignUpScreen : Screen("signup_screen")
    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
