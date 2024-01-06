package com.example.buddybudget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewGroupScreen(navController: NavController) {
    Row (horizontalArrangement = Arrangement.Center){
        Column{
            Text(text = "Group Name")
            TextField(
                value = "",
                onValueChange = {it},
                label = {Text("Enter name of group")}
                )
            Text(text = "Group Description")
            TextField(
                value = "",
                onValueChange = {it},
                label = {Text("Enter description for group")}
            )
            Text(text = "Search for Participants")
            TextField(
                value = "",
                onValueChange = {it},
                label = {Text("Add Person to Group")}
            )
            Button(onClick = {}) {
                Text(text = "CREATE GROUP")
            }
        }
    }

}