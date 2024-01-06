package com.example.buddybudget

sealed class Screen(val route: String) {
    object MainScreen : Screen("main_screen")
    object LoginScreen : Screen("login_screen")
    object SplashScreen : Screen("splash_screen")
    object NewGroupScreen : Screen("newGroup_screen")
    object EditGroupScreen : Screen("editGroupScreen")
    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
