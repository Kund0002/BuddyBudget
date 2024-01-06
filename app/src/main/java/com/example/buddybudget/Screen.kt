package com.example.buddybudget

sealed class Screen(val route: String) {
    object HomeScreen : Screen("home_screen")
    object LoginScreen : Screen("login_screen")
    object SplashScreen : Screen("splash_screen")
    object PreLoginScreen :Screen("prelogin_screen")
    object SignUpScreen : Screen("signup_screen")
    object UserEditScreen : Screen("useredit_screen")
    object UserInformationScreen : Screen("userinformation_screen")
    object NewGroupScreen : Screen("newgroup_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
