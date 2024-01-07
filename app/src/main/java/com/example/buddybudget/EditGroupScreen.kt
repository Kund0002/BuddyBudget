package com.example.buddybudget

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditGroupScreen(navController: NavController) {
    val Roman = FontFamily(Font(R.font.crimson_bold, FontWeight.Normal))
    var groupName by remember { mutableStateOf("") }
    var groupDesc by remember { mutableStateOf("") }

    Column (
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp)
    ) {
        NavBar(navController, "username" )

        Image(
            painter = painterResource(id = R.drawable.back),
            contentDescription = "Logo",
            modifier = Modifier
                .clickable { navController.navigate(Screen.HomeScreen.route) }
                .fillMaxWidth()
        )

        Text(
            fontFamily = Roman,
            fontSize = 25.sp,
            color = Color.Cyan,
            modifier = Modifier.padding(15.dp),
            text = "Group Name"
        )

        OutlinedTextField(
            value = groupName, onValueChange = { groupName = it },
            label = { Text("Enter name of group") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )

        Text(
            fontFamily = Roman,
            fontSize = 25.sp,
            color = Color.Cyan,
            modifier = Modifier.padding(15.dp),
            text = "Group Description"
        )

        OutlinedTextField(
            value = groupDesc, onValueChange = { groupDesc = it },
            label = { Text("Enter description for group") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )

        Text(
            fontFamily = Roman,
            fontSize = 25.sp,
            color = Color.Cyan,
            modifier = Modifier.padding(15.dp),
            text = "Search for Participants"
        )

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