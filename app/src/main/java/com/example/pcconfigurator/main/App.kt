package com.example.pcconfigurator.main

import android.app.Application
import com.example.pcconfigurator.di.AppComponent
import com.example.pcconfigurator.di.DaggerAppComponent

class App : Application() {
    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        component =
            DaggerAppComponent
                .builder()
                .getContext(this)
                .build()
    }
}
