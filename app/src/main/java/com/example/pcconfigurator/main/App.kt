package com.example.pcconfigurator.main

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import com.example.pcconfigurator.di.AppComponent
import com.example.pcconfigurator.di.DaggerAppComponent
import com.example.pcconfigurator.utils.CounterNotificationService

class App : Application() {
    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        component =
            DaggerAppComponent
                .builder()
                .getContext(this)
                .build()
        createNotificationService()
    }

    private fun createNotificationService() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel: NotificationChannel = NotificationChannel(
                CounterNotificationService.ID,
                CounterNotificationService.NAME,
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description = "User for the increment counter notifications"
            }

            val notificationManager: NotificationManager =
                getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}
