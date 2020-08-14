package com.nokey.vtmcompanion.ext

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.inject.Provider
import java.lang.Exception
import java.lang.RuntimeException
import javax.inject.Inject

class ViewModelFactory @Inject constructor(
    private val builders: Map<Class<out ViewModel>, Provider<ViewModel>>
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        var builder = builders[modelClass]

        if (builder == null) {
            for ((key, value) in builders) {
                if (modelClass.isAssignableFrom(key)) {
                    builder = value
                    break
                }
            }
        }

        checkNotNull(builder) {
            "Class Not Found: ${modelClass.name} needs to be bound in ViewModelBindings"
        }

        try {
            @Suppress("UNCHECKED_CAST")
            return builder.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}