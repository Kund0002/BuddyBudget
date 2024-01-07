package com.example.buddybudget

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewGroupScreen(navController: NavController) {
    val Roman = FontFamily(Font(R.font.crimson_bold, FontWeight.Normal))
    var groupName by remember { mutableStateOf("") }
    var groupDesc by remember { mutableStateOf("") }
    var participants by remember { mutableStateOf("") }


    Column(
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


        OutlinedTextField(
            value = participants, onValueChange = { participants = it },
            label = { Text("Add Person to Group") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )

        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(Color.Cyan),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .weight(1f, fill = false)
                .padding(5.dp)
                .padding(horizontal = 30.dp)
        ) {
            Text(text = "CREATE GROUP", fontSize = 20.sp)
        }
    }
}