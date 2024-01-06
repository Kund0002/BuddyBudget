package com.example.buddybudget

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var phoneNr by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column {
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = phoneNr,
            onValueChange = { phoneNr = it },
            label = { Text("Phone Number") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Repeat Password") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                navController.navigate(Screen.SignUpScreen.route)
            },
            colors = ButtonDefaults.buttonColors(Color.Cyan),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .weight(1f, fill = false)
                .padding(5.dp)
                .padding(horizontal = 50.dp)

        ) {
            Text(text = "Create account", fontSize = 25.sp,)

        }
        
        LoginButton(navController)
    }
}

@Composable
fun LoginButton(navController: NavController) {
    Text(
        modifier = Modifier.clickable { navController.navigate(Screen.LoginScreen.route) },
        text = "Already have an account? Login"
    )
}