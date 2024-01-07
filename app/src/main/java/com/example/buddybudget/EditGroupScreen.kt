package com.example.buddybudget

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditGroupScreen(navController: NavController) {
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
        Text(text = "Group Members")
        LazyColumn(modifier=Modifier.fillMaxSize()) {
            items(items = groups, key = { it.id }) { task ->
                ListItem(
                    headlineText = { Text(text = task.name) },
                    trailingContent = {
                        Icon(imageVector = Icons.Default.MoreVert, contentDescription = task.name)
                    }
                )
            }
        }
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

data class Groups(
    val id: Int,
    val name: String,
)

val groups = listOf(
    Groups(1,"Jens"),
    Groups(2,"Lone")
)