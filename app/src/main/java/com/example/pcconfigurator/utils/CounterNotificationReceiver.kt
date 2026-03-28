package com.example.pcconfigurator.utils

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class CounterNotificationReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {
        CounterNotificationService(context).showNotification(++Counter.value)
    }
}