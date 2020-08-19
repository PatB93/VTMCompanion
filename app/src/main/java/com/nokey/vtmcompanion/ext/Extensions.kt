package com.nokey.vtmcompanion.ext

import android.content.Context
import androidx.annotation.ArrayRes
import androidx.viewbinding.ViewBinding

fun ViewBinding.requireContext(): Context {
    return this.root.context
}

fun Context.getStringArray(@ArrayRes res: Int): Array<String> = this.resources.getStringArray(res)
