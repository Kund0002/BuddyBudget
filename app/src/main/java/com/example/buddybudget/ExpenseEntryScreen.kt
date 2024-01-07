package com.example.buddybudget

import android.graphics.Paint.Align
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExpenseEntryScreen(navController: NavController) {
    var totalAmount by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    val Roman = FontFamily(
        Font(R.font.crimson_roman, FontWeight.Normal)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Total Amount",
            fontFamily = Roman,
            fontSize = 35.sp,
            color = Color.Cyan,
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
        )
        OutlinedTextField(
            value = totalAmount, onValueChange = { totalAmount = it },
            label = { Text("Enter Amount") },
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .width(320.dp)
                .padding(10.dp)
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Description",
            fontSize = 35.sp,
            color = Color.Cyan,
            fontFamily = Roman,
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            )
        OutlinedTextField(
            value = description, onValueChange = { description = it },
            label = { Text("Enter Amount") },
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .width(320.dp)
                .padding(10.dp)
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Group Members",
            fontSize = 35.sp,
            fontFamily = Roman,
            color = Color.Cyan,
            modifier = Modifier
                .absolutePadding(left = 20.dp)
            )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                // TODO: Add expense to database
            },
            colors = ButtonDefaults.buttonColors(Color.Cyan),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .weight(1f, fill = false)
                .padding(5.dp)
                .padding(horizontal = 50.dp)
        ) {
            Text(text = "ADD EXPENSE", fontSize = 25.sp)
        }
    }
}

@Composable
fun GroupListMembers(group: Group) {
    // Customize the appearance of each group item
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(androidx.compose.ui.graphics.Color.Gray)
            .clickable { /* Handle group item click */ }
            .border(1.dp, Color.Gray, RoundedCornerShape(10.dp))
    ) {
        Text(text = group.name, fontWeight = FontWeight.Bold, fontSize = 16.sp)
        Text(text = group.description, modifier = Modifier.padding(top = 4.dp))
    }
}