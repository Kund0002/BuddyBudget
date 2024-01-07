package com.example.buddybudget

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserInformationScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.usersettlogo),
            contentDescription = "Logo",
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = "Mail@example.com",
            onValueChange = {},
            readOnly = true,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(8.dp))
        TextField(
            value = "Name Nameson",
            onValueChange = {},
            readOnly = true,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(8.dp))
        TextField(
            value = "12 34 56 78",
            onValueChange = {},
            readOnly = true,
            modifier = Modifier.fillMaxWidth()
        )

        EditUserInfo(navController)
    }
}

@Composable
fun EditUserInfo(navController: NavController) {
    Text(
        modifier = Modifier.clickable { navController.navigate(Screen.UserEditScreen.route) },
        text = "Edit User Information"
    )
}
