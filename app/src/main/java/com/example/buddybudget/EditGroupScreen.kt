package com.example.buddybudget

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditGroupScreen(navController: NavController, name: String?) {
    Column{
        Text(text = "Group Name")
        TextField(
            value = "",
            onValueChange = {it},
            label = { Text("Enter name of group") }
        )
        Text(text = "Group Description")
        TextField(
            value = "",
            onValueChange = {it},
            label = { Text("Enter description for group") }
        )
        Text(text = "Search for Participants")
        TextField(
            value = "",
            onValueChange = {it},
            label = { Text("Add Person to Group") }
        )
        Button(onClick = {}) {
            Text(text = "CREATE GROUP")
        }
        Text(text = "Group Members")
    }
}




