package com.example.buddybudget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.unit.dp


@Composable
fun NavBar(string: String) {
    var name = string

    Row(
        modifier = Modifier.background(Color.White),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Image(
            painter = painterResource(id = R.drawable.userlogo),
            contentDescription = "Logo",
        )
        Text(
            modifier = Modifier
                .padding(10.dp)
                .align(Alignment.CenterVertically),
            text = name
        )
        Spacer(modifier = Modifier.fillMaxWidth(0.6f))

        Image(
            painter = painterResource(id = R.drawable.newgrouplogo),
            contentDescription = "Logo",
        )
    }

    /*BottomNavigation (
        modifier = Modifier.background(Color.White)
    ) {
        BottomNavigationItem(
            modifier = Modifier.background(Color.White),
            icon = { Icon(Icons.Default.AccountBox, contentDescription = null) },
            label = { Text(name)},
            selected = true,
            onClick = { /* Handle navigation to Home screen */ }
        )

        Spacer(modifier = Modifier
            .weight(1f)
            .background(Color.White)
        )

        BottomNavigationItem(
            modifier = Modifier.background(Color.White),
            icon = { Icon(Icons.Default.AddCircle, contentDescription = null) },
            selected = false,
            onClick = { /* Handle navigation to Search screen */ }
        )
        // Add more items as needed
    }*/
}