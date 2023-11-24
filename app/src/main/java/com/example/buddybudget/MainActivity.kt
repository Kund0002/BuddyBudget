package com.example.buddybudget

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.buddybudget.ui.theme.BuddyBudgetTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //AppContent()
            Navigation()
            }
        }
    }

/*
data class Message(val author: String, val body: String)



@Composable
fun AppContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.buddybudget_logo),
            contentDescription = "logo",
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
                .align(Alignment.CenterHorizontally)
        )

        MyButton("LOG IN")

        Spacer(modifier = Modifier.height(20.dp))

        MyButton("CREATE ACCOUNT")

    }
}

@Composable
fun MyButton(text: String) {
    Button(onClick = {},
        modifier = Modifier
            .height(50.dp)
            .width(250.dp)
        )
    {
        Text(text)
    }
}
*/

@Preview
@Composable
fun PreviewMessageCard() {
    Navigation()
}
