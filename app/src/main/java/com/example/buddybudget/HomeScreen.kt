package com.example.buddybudget

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun HomeScreen(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .border(5.dp, Color.LightGray, RoundedCornerShape(10.dp))
            .padding(vertical = 10.dp, horizontal = 5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        NavBar(navController, string = "User")
        Box(modifier = Modifier
            .padding(horizontal = 50.dp, vertical = 5.dp)
            .border(2.dp, Color.Cyan, RoundedCornerShape(5.dp))
            .clickable{navController.navigate(Screen.ExpenseEntryScreen.route)},

            ){
            Column {
                Text(
                    text = "Drinks",
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(2.dp, Color.Blue, RoundedCornerShape(5.dp))
                        .padding(5.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Total: 1800 Kr")
                    Text(text = "Owed: 250 Kr")
                }

                Button(
                    colors = ButtonDefaults.buttonColors(Color.Cyan),
                    onClick = { navController.navigate(Screen.EditGroupScreen.route) },
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .fillMaxWidth()
                        .weight(1f, fill = false)
                        .padding(5.dp)
                        .padding(horizontal = 50.dp)

                ) {
                    Text(text = "Edit Group", fontSize = 15.sp)
                }
            }
        }
        Box(modifier = Modifier
            .padding(horizontal = 50.dp, vertical = 5.dp)
            .border(2.dp, Color.Cyan, RoundedCornerShape(5.dp))
            .clickable{navController.navigate(Screen.ExpenseEntryScreen.route)},

        ){
            Column {
                Text(
                    text = "Food",
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(2.dp, Color.Blue, RoundedCornerShape(5.dp))
                        .padding(5.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp

                )
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Total: 900 Kr")
                    Text(text = "Owe: 250 kr")
                }

                Button(
                    colors = ButtonDefaults.buttonColors(Color.Cyan),
                    onClick = { navController.navigate(Screen.EditGroupScreen.route) },
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .fillMaxWidth()
                        .weight(1f, fill = false)
                        .padding(5.dp)
                        .padding(horizontal = 50.dp)

                ) {
                    Text(text = "Edit Group", fontSize = 15.sp)
                }
            }
        }
        Box(modifier = Modifier
            .padding(horizontal = 50.dp, vertical = 5.dp)
            .border(2.dp, Color.Cyan, RoundedCornerShape(5.dp))
            .clickable{navController.navigate(Screen.ExpenseEntryScreen.route)},

            ){
            Column {
                Text(
                    text = "Fishing trip",
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(2.dp, Color.Blue, RoundedCornerShape(5.dp))
                        .padding(5.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp

                )
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Total: 1000 Kr")
                    Text(text = "Owed: 600 Kr")
                }

                Button(
                    colors = ButtonDefaults.buttonColors(Color.Cyan),
                    onClick = { navController.navigate(Screen.EditGroupScreen.route) },
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .fillMaxWidth()
                        .weight(1f, fill = false)
                        .padding(5.dp)
                        .padding(horizontal = 50.dp)

                ) {
                    Text(text = "Edit Group", fontSize = 15.sp)
                }
            }
        }
    }
}


/**The below code was for checking is the user was part of any groups, and then displaying the groups here
 * ideally, the app should check if the current logged in user was part of any groups, but due to time constraints
 * have been replaced by a visual example of how it would look like
 **/
/* fun HomeScreen(navController: NavController, dbHelper: DatabaseHelper, userId: Int) {
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
}*/