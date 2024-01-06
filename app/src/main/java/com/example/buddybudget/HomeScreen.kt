package com.example.buddybudget

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController, dbHelper: DatabaseHelper, userId: Int) {
    val userGroups = dbHelper.getUserGroups(userId)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Your Expense Groups", fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Spacer(modifier = Modifier.height(16.dp))

        if (userGroups.isNotEmpty()) {
            LazyColumn {
                items(userGroups) { group ->
                    GroupListItem(group = group)
                }
            }
        } else {
            Text(text = "You are not part of any expense groups.")
        }
    }
}

@Composable
fun GroupListItem(group: Group) {
    // Customize the appearance of each group item
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(androidx.compose.ui.graphics.Color.Gray)
            .clickable { /* Handle group item click */ }
    ) {
        Text(text = group.name, fontWeight = FontWeight.Bold, fontSize = 16.sp)
        Text(text = group.description, modifier = Modifier.padding(top = 4.dp))
    }
}