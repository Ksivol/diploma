package com.example.pcconfigurator.main

import android.content.Context
import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.pcconfigurator.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(SystemBarStyle.auto(Color.WHITE, Color.WHITE) { true })
        setContentView(R.layout.activity_main)
        window.statusBarColor = if (isDarkTheme(this)) getColor(R.color.colorPrimaryDark) else getColor(R.color.colorPrimaryLight)
    }

    private fun isDarkTheme(context: Context) =
        context.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES
}
