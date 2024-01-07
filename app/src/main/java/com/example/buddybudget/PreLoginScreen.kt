package com.example.buddybudget

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun PreLoginScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        NavBar(string = "kundayi lugter lol")
        Image(
            painter = painterResource(id = R.drawable.buddybudget_logo),
            contentDescription = "Logo",
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(150.dp))

        Button(
            onClick = {
                navController.navigate(Screen.LoginScreen.route)
            },
            colors = ButtonDefaults.buttonColors(Color.Cyan),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .weight(1f, fill = false)
                .padding(5.dp)
                .padding(horizontal = 50.dp)


        ) {

            Text(text = "Login", fontSize = 25.sp)
        }
        Button(
            //change Screen.MainScreen.route to the create account screen when implemented
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
    }

}
