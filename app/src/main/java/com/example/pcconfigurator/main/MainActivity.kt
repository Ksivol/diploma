package com.example.pcconfigurator.main

import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.pcconfigurator.R
import com.example.pcconfigurator.di.component
import com.github.terrakok.cicerone.NavigatorHolder
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject lateinit var navigatorHolder: NavigatorHolder
    @Inject lateinit var factory: ViewModelProvider.Factory
    private val isDarkTheme: Boolean
        get() = this.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(SystemBarStyle.auto(Color.WHITE, Color.WHITE) { true })
        setContentView(R.layout.activity_main)
        window.statusBarColor =
            if (isDarkTheme) getColor(R.color.colorPrimaryDark) else getColor(R.color.colorPrimaryLight)
    }
}
