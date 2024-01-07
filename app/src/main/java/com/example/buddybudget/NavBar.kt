package com.example.buddybudget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun NavBar(navController: NavController, string: String) {
    var name = string
    val Roman = FontFamily(Font(R.font.crimson_bold, FontWeight.Normal))

    Row(
        modifier = Modifier
            .height(100.dp)
            .background(Color.White),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(

            painter = painterResource(id = R.drawable.userlogo),
            contentDescription = "Logo",
<<<<<<< HEAD
=======

>>>>>>> 96a309a92b6c0d3f3aa00b3ea13a76514fefdb5b
            modifier = Modifier.clickable { navController.navigate(Screen.UserInformationScreen.route) }
        )
        Text(
            fontFamily = Roman,
            fontSize = 25.sp,
            color = Color.Cyan,
            modifier = Modifier
                .padding(15.dp),
            text = name
        )
        Spacer(modifier = Modifier.fillMaxWidth(0.55f))

        Image(
            painter = painterResource(id = R.drawable.newgrouplogo),
            contentDescription = "Logo",
            modifier = Modifier.clickable { navController.navigate(Screen.NewGroupScreen.route) }
        )
    }
}