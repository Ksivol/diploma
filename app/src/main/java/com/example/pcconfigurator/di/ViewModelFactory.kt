package com.example.pcconfigurator.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory
    @Inject
    constructor(
        private val viewModels: MutableMap<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>,
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            val creator =
                viewModels[modelClass] ?: viewModels.entries
                    .firstOrNull {
                        modelClass.isAssignableFrom(it.key)
                    }?.value
                    ?: throw IllegalArgumentException("Unknown model class ${modelClass.simpleName}")
            try {
                @Suppress("UNCHECKED_CAST")
                return creator.get() as T
            } catch (e: Exception) {
                throw RuntimeException(e)
            }
        }
    }
