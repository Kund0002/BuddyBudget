package com.example.buddybudget

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        const val DATABASE_NAME = "BuddyBudget.db"
        const val DATABASE_VERSION = 1
    }

    //create user table
    private val CREATE_TABLE_USERS = """
        CREATE TABLE users (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            name TEXT,
            email TEXT UNIQUE
            
        )
    """

    //create group table
    private val CREATE_TABLE_GROUPS = """
        CREATE TABLE groups (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            name TEXT,
            description TEXT
        )
    """

    //create expenses table
    private val CREATE_TABLE_EXPENSES = """
        CREATE TABLE expenses (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            payer_id INTEGER,
            group_id INTEGER,
            amount REAL,
            receipt_url TEXT,
            FOREIGN KEY (payer_id) REFERENCES users(id),
            FOREIGN KEY (group_id) REFERENCES groups(id)
        )
    """

    private val CREATE_TABLE_TRANSACTIONS = """
        CREATE TABLE transactions (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            debtor_id INTEGER,
            creditor_id INTEGER,
            expense_id INTEGER,
            amount REAL,
            FOREIGN KEY (debtor_id) REFERENCES users(id),
            FOREIGN KEY (creditor_id) REFERENCES users(id),
            FOREIGN KEY (expense_id) REFERENCES expenses(id)
        )
    """
    //dummy user for testing purposes
    private fun createTestUser(db: SQLiteDatabase) {
        val dummyUserName = "Alice mcCool"
        val dummyUserEmail = "Alice.mccool@yahoo.dk"

        val values = ContentValues().apply {
            put("name", dummyUserName)
            put("email", dummyUserEmail)

        }

        // Insert the dummy user into the 'users' table
        db.insert("users", null, values)
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_TABLE_USERS)
        db.execSQL(CREATE_TABLE_GROUPS)
        db.execSQL(CREATE_TABLE_EXPENSES)
        db.execSQL(CREATE_TABLE_TRANSACTIONS)

        createTestUser(db)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}