package com.example.buddybudget

import android.annotation.SuppressLint
import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class NotificationCenter {
    @SuppressLint("MissingPermission")
    fun showLoginNotification(context: Context) {
        val notificationId = 1
        val builder = NotificationCompat.Builder(context, "notification_channel")
            .setSmallIcon(R.drawable.ic_stat_name)
            .setContentTitle("Login Successful")
            .setContentText("Hi, you have successfully logged in to BuddyBudget")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(NotificationManagerCompat.from(context)) {
            notify(notificationId, builder.build())
        }
    }
}