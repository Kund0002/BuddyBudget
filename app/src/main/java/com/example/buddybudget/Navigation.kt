package com.example.buddybudget

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
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
        composable(route = Screen.ExpenseEntryScreen.route) {
            ExpenseEntryScreen(navController = navController)
        }
        composable(route = Screen.UserInformationScreen.route) {
            UserInformationScreen(navController = navController)
        }
        composable(route = Screen.NewGroupScreen.route) {
            NewGroupScreen(navController = navController)
        }
            composable(route = Screen.HomeScreen.route) {
                HomeScreen(navController = navController)
            }
            //this was for instantiating the db helper, for testing that we could pull from the database
            /*   composable(route = Screen.HomeScreen.route) {
                HomeScreen(
                    navController = navController,
                    dbHelper = DatabaseHelper(context = LocalContext.current),
                    userId = currentUser.id
                )

            }
        }
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(navController = navController, dbHelper = DatabaseHelper(context = LocalContext.current), userId = currentUser.id)
        } */

            composable(
                route = Screen.NewGroupScreen.route + "/{groupName}",
                arguments = listOf(
                    navArgument("groupName") {
                        type = NavType.StringType
                        defaultValue = "testGroup"
                        nullable = true
                    }
                )
            ) { entry ->
                //EditGroupScreen(navController = navController)

            }
        composable(route = Screen.EditGroupScreen.route){
            EditGroupScreen(navController = navController)
        }
        }
    
    }
