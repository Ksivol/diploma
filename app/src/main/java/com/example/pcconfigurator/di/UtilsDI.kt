package com.example.pcconfigurator.di

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.example.pcconfigurator.main.App
import dagger.MapKey
import kotlin.reflect.KClass

val Context.component: AppComponent
    get() = when (this) {
        is App -> component
        else -> this.applicationContext.component
    }

val AppCompatActivity.component: AppComponent
    get() = this.applicationContext.component

val Fragment.component: AppComponent
    get() = requireContext().component

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(
    val value: KClass<out ViewModel>,
)
