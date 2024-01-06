package com.example.buddybudget

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.SplashScreen.route) {
        composable(route = Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.LoginScreen.route) {
            LoginScreen(navController = navController)
        }
        composable(route = Screen.SignUpScreen.route) {
            SignUpScreen(navController = navController)
        }
        composable(route = Screen.PreLoginScreen.route) {
            PreLoginScreen(navController = navController)
        }
        composable(route = Screen.UserEditScreen.route) {
            UserEditScreen(navController = navController)
        }
        composable(route = Screen.UserInformationScreen.route) {
            UserInformationScreen(navController = navController)
        }
        composable(route = Screen.NewGroupScreen.route) {
            NewGroupScreen(navController = navController)
        composable(route = Screen.HomeScreen.route){
            HomeScreen(navController = navController, dbHelper = DatabaseHelper(context = LocalContext.current), userId = currentUser.id)

        }
        composable(
            route = Screen.HomeScreen.route + "/{name}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "test"
                    nullable = true
                }
            )
        ) { entry ->
            HomeScreen(name = entry.arguments?.getString("name"))
        }


        }
    }

