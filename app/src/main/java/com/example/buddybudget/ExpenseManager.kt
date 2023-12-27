package com.example.buddybudget

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase

data class Expense(val payer: String, val amount: Double, val participants: List<String>)

class ExpenseManager(private val dbHelper: DatabaseHelper) {

    fun addExpense(expense: Expense) {
        val db = dbHelper.writableDatabase
        try {
            db.beginTransaction()

            val totalParticipants = expense.participants.size
            val individualShare = expense.amount / totalParticipants

            // Deduct individual share from payer
            updateBalance(db, expense.payer, -expense.amount)

            // Add individual share to each participant
            for (participant in expense.participants) {
                updateBalance(db, participant, individualShare)
            }

            // Save the expense details in the expenses table
            saveExpense(db, expense)

            db.setTransactionSuccessful()
        } finally {
            db.endTransaction()
            db.close()
        }
    }

    private fun updateBalance(db: SQLiteDatabase, person: String, amount: Double) {
        val currentBalance = getBalance(db, person)
        setBalance(db, person, currentBalance + amount)
    }

    private fun getBalance(db: SQLiteDatabase, person: String): Double {
        val cursor = db.rawQuery("SELECT balance FROM users WHERE name=?", arrayOf(person))
        return if (cursor.moveToFirst()) {
            cursor.getDouble(0)
        } else {
            0.0
        }
    }

    private fun setBalance(db: SQLiteDatabase, person: String, balance: Double) {
        val values = ContentValues().apply {
            put("balance", balance)
        }
        db.update("users", values, "name=?", arrayOf(person))
    }

    private fun saveExpense(db: SQLiteDatabase, expense: Expense) {
        val values = ContentValues().apply {
            put("payer_id", getUserId(db, expense.payer))
            // Add other expense details to the ContentValues as needed


        }
        db.insert("expenses", null, values)
    }

    private fun getUserId(db: SQLiteDatabase, userName: String): Long {
        val cursor = db.rawQuery("SELECT id FROM users WHERE name=?", arrayOf(userName))
        return if (cursor.moveToFirst()) {
            cursor.getLong(0)
        } else {
            0L
        }
    }

    fun getBalances(): Map<String, Double> {
        val db = dbHelper.readableDatabase
        val balances = mutableMapOf<String, Double>()
        db.use { db ->
            val cursor = db.rawQuery("SELECT name, balance FROM users", null)
            while (cursor.moveToNext()) {
                val name = cursor.getString(0)
                val balance = cursor.getDouble(1)
                balances[name] = balance
            }
        }
        return balances
    }
}
