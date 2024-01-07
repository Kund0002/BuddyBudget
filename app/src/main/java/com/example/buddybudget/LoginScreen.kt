package com.example.buddybudget

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.loginlogo),
            contentDescription = "Logo",
            modifier = Modifier.fillMaxWidth()
        )
        Text(text = "Email")
        TextField(
            value = username,
            onValueChange = { username = it },
            modifier = Modifier.fillMaxWidth()
        )
        Text(text = "Password")
        TextField(
            value = password,
            onValueChange = { password = it },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = { navController.navigate(Screen.HomeScreen.route) },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "To Login Screen")
        }
        SignUpButton(navController)

        Button(
            onClick = { navController.navigate(Screen.UserInformationScreen.route) },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "To User Info")
        }
    }
}

@Composable
fun SignUpButton(navController: NavController) {
    Text(
        modifier = Modifier.clickable { navController.navigate(Screen.SignUpScreen.route) },
        text = "Don't have an account? Sign up"
    )
}