package com.example.buddybudget

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.buddybudget.ui.theme.BuddyBudgetTheme

data class User(val name: String)
data class Debt(val debtor: User, val creditor: User, val amount: Double)

val currentUser = User("Alice")
val debts = listOf(
    Debt(User("Alice"), User("Bob"), 50.0),
    Debt(User("Charlie"), User("Alice"), 30.0),
    Debt(User("Alice"), User("Dave"), 20.0)
)


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BuddyBudgetTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingScreen(currentUser, debts)
                }
            }
        }
    }
}

@Composable
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
fun GreetingPreview() {
    BuddyBudgetTheme {
        Greeting("User")
    }
}