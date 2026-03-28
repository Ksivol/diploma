package com.example.pcconfigurator.utils

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.example.pcconfigurator.R
import com.example.pcconfigurator.main.MainActivity

class CounterNotificationService(private val context: Context) {
    private val notificationManager: NotificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    fun showNotification(counter: Int): Unit {
        val pendingActivityIntent: PendingIntent = PendingIntent.getActivity(
            context,
            1,
            Intent(context, MainActivity::class.java),
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) PendingIntent.FLAG_IMMUTABLE else 0
        )

        val pendingBroadcastIntent: PendingIntent = PendingIntent.getBroadcast(
            context,
            2,
            Intent(context, CounterNotificationReceiver::class.java),
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) PendingIntent.FLAG_IMMUTABLE else 0
        )
        val notification: Notification = NotificationCompat
            .Builder(context, ID)
            .setContentTitle("Some title")
            .setContentText("Some text with increment: $counter")
            .setContentIntent(pendingActivityIntent)
            .addAction(
                R.drawable.ic_build,
                "Some title",
                pendingBroadcastIntent
            )
            .build()

        notificationManager.notify(1, notification)
    }

    companion object {
        const val ID: String = "counter notification id"
        const val NAME: String = "counter notification name"
    }
}