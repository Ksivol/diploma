package com.example.pcconfigurator.di

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.example.pcconfigurator.main.App
import dagger.MapKey
import kotlin.reflect.KClass

val Context.appComponent: AppComponent
    get() = when (this) {
        is App -> appComponent
        else -> this.applicationContext.appComponent
    }

val Fragment.appComponent: AppComponent
    get() = requireContext().appComponent

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(
    val value: KClass<out ViewModel>,
)
