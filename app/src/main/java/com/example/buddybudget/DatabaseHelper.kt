package com.example.buddybudget

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.core.content.contentValuesOf
import org.w3c.dom.Text

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        const val DATABASE_NAME = "BuddyBudget.db"
        const val DATABASE_VERSION = 3
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
    //create table for groups users are part of
    private val CREATE_TABLE_USER_GROUPS = """
        CREATE TABLE user_groups (
        user_id INTEGER,
        group_id, INTEGER,
        PRIMARY KEY (user_id, group_id),
        FOREIGN KEY (user_id) REFERENCES users(id),
        FOREIGN KEY (group_id) REFERENCES groups(id)
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
    private fun createTestUser(db: SQLiteDatabase, dummyUserName: String, dummyUserEmail: String) {
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
        db.execSQL(CREATE_TABLE_USER_GROUPS)
        db.execSQL(CREATE_TABLE_EXPENSES)
        db.execSQL(CREATE_TABLE_TRANSACTIONS)

        //creating the test users
        createTestUser(db, "Alice McCool", "alice.mccool11@yahoo.com")
        createTestUser(db, "Tom Thomson", "tomthomson@gmail.com")
        createTestUser(db, "Rose tyler", "tyler.rose@yahoo.com")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    private fun getUserIdByEmail(db: SQLiteDatabase?, email: String): Long {
        db?.let {
            val cursor = db.rawQuery("SELECT id FROM users WHERE email=?", arrayOf(email))
            return if (cursor.moveToFirst()) {
                cursor.getLong(0)
            } else {
                -1L
            }
        }
        return -1L //Iam not being allowed to not handle nullables so we are doing this now. It shouldnt be possible to have nullables but whatever

    }
    fun insertUser(name: String, email: String): Long {
        val db = writableDatabase
        var userId: Long  = -1 //this value means adding user failed

        try {
            //check if user with same email exists
            db.beginTransaction()
            val existingUserId = getUserIdByEmail(db, email)
            if (existingUserId != -1L){
                //existing user found
                return existingUserId
            }
            //new user, insert stuff
            val values = ContentValues().apply {
                put("Name", name)
                put("email", email)
            }
            userId = db.insert("users", null, values)
            db.setTransactionSuccessful()
        }
        finally {
            db.endTransaction()
            db.close()

        }
        return userId
    }

    //add user to already created group
    fun addUserToGroup(name: String, userId: Int, groupId: Int) {
        val db = writableDatabase
        val values = ContentValues().apply {
            put("user_id", userId)
            put("group_id", groupId)
        }
        db.insert("user_groups", null, values)
        db.close()
    }

    fun getUserGroups(userId: Int): List<Group> {
        val db = readableDatabase
        val groups = mutableListOf<Group>()

        val query = """
            SELECT groups.id, groups.name, groups.description
            FROM groups
            INNER JOIN user_groups ON groups.id = user_groups.group_id
            WHERE user_groups.user_id = ?
        """

        db.rawQuery(query, arrayOf(userId.toString())).use { cursor ->
            while (cursor.moveToNext()) {
                val groupId = cursor.getLong(0)
                val groupName = cursor.getString(1)
                val groupDescription = cursor.getString(2)
                groups.add(Group(groupId, groupName, groupDescription))
            }
        }

        db.close()
        return groups
    }
}

