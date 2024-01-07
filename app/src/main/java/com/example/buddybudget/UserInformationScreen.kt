package com.example.buddybudget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserInformationScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var phoneNr by remember { mutableStateOf("") }
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 50.dp)
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Image(
                painter = painterResource(id = R.drawable.usersettlogo),
                contentDescription = "Logo",
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(60.dp))
            Box(
                modifier = Modifier
                    .fillMaxHeight(0.8F)
                    .fillMaxWidth()
                    .border(
                        width = 2.dp,
                        color = Color.Gray,
                        shape = RectangleShape
                    )
                    .background(Color.White)
                    .padding(15.dp)
            ) {
                Column (
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                ) {
                    Text(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally),
                        text = "User Information",
                        fontSize = 20.sp
                    )

                    OutlinedTextField(
                        value = email, onValueChange = { email = it },
                        label = { Text("Email") },
                        readOnly = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    )
                    OutlinedTextField(
                        value = name, onValueChange = { name = it },
                        label = { Text("Name") },
                        readOnly = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    )
                    OutlinedTextField(
                        value = phoneNr, onValueChange = { phoneNr = it },
                        label = { Text("Phone Number") },
                        readOnly = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    )

                }

            }
            Button(
                onClick = {
                    navController.navigate(Screen.UserEditScreen.route)
                },
                colors = ButtonDefaults.buttonColors(Color.Cyan),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .weight(1f, fill = false)
                    .padding(5.dp)
                    .padding(horizontal = 30.dp)

            ) {
                Text(text = "Edit", fontSize = 25.sp,)

            }
        }
    }
