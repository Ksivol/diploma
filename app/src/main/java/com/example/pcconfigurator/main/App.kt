package com.example.pcconfigurator.main

import android.app.Application
import com.example.pcconfigurator.di.AppComponent
import com.example.pcconfigurator.di.DaggerAppComponent

class App : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .builder()
            .getContext(this)
            .build()
    }
}
