package com.nokey.vtmcompanion.ext

import android.content.Context
import androidx.viewbinding.ViewBinding

fun ViewBinding.requireContext(): Context {
    return this.root.context
}