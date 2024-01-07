package com.example.buddybudget

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewGroupScreen(navController: NavController) {
    val name by remember { mutableStateOf("") }
    val description by remember { mutableStateOf("") }



        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(text = "Group Name")
            TextField(
                value = "",
                onValueChange = {},
                label = {Text("Enter name of group")}
                )
            Text(text = "Group Description")
            Spacer(modifier = Modifier.height(10.dp))
            TextField(
                value = "",
                onValueChange = {},
                label = {Text("Enter description for group")}
            )
            Text(text = "Search for Participants")
            Spacer(modifier = Modifier.height(10.dp))

            TextField(
                value = "",
                onValueChange = {},
                label = {Text("Add Person to Group")}
            )
            Spacer(modifier = Modifier.height(10.dp))

            Button(onClick = {}) {
                Text(text = "CREATE GROUP")
            }
        }
    }
