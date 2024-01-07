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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
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

import androidx.compose.ui.res.painterResource

import androidx.compose.ui.platform.LocalContext

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
    val context = LocalContext.current

    Column (
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp)
    ){
        Spacer(modifier = Modifier.height(100.dp))
        Image(
            painter = painterResource(id = R.drawable.createacclogo),
            contentDescription = "Logo",
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = email, onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )
        OutlinedTextField(
            value = name, onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )
        OutlinedTextField(
            value = phoneNr, onValueChange = { phoneNr = it },
            label = { Text("Phone Number") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )
        OutlinedTextField(
            value = password, onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )

        Button(
            onClick = {
                navController.navigate(Screen.SignUpScreen.route)
                NotificationCenter().showLoginNotification(context)
            },
            colors = ButtonDefaults.buttonColors(Color.Cyan),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .weight(1f, fill = false)
                .padding(5.dp)
                .padding(horizontal = 30.dp)

        ) {
            Text(text = "Create account", fontSize = 25.sp,)

        }
        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .clickable { navController.navigate(Screen.LoginScreen.route) },
            text = "Already have an account? Login."
        )
    }
}