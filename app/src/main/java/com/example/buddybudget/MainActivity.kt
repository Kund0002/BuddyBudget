package com.example.buddybudget

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

data class User(val name: String, val id: Int)
data class Debt(val debtor: User, val creditor: User, val amount: Double)

val currentUser = User("Alice", 12,)


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createNotificationChannel()
        setContent {
            //user-registration
            //AppContent()
            Navigation()
            }
        val dbHelper = DatabaseHelper(this)
        }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name ="BuddyBudget"
            val descriptionText = "BuddyBudget notification channel"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("notification_channel", name, importance).apply {
                description = descriptionText
            }
            val notificationManager: NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}

/*
data class Message(val author: String, val body: String)



@Composable
user-registration
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


fun GreetingScreen(currentUser: User, debts: List<Debt>) {
    var owed = calculateAmountOwedToOthers(currentUser, debts)
    Text(
        text = "Hello ${currentUser.name} ! You owe $owed kroner in total"
    )


}



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    var owed = calculateAmountOwedToOthers(currentUser, debts)
    Text(
        text = "Hello $name! You owe $owed in total",
        modifier = modifier
    )
}

fun calculateAmountOwedToOthers(currentUser: User, debts: List<Debt>): Double {
    var totalAmount = 0.0

    debts.forEach { debt ->
        if (debt.debtor == currentUser) {
            totalAmount += debt.amount
        }
    }

    return totalAmount
}

@Preview(showBackground = true)
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
