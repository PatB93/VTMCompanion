package com.nokey.vtmcompanion.data

import androidx.annotation.StringRes
import com.nokey.vtmcompanion.R

enum class Clans(@StringRes val stringRes: Int) {
    NOSFERATU(R.string.nosferatu),
    VENTRUE(R.string.ventrue),
    TOREADOR(R.string.toreador),
    BRUJA(R.string.bruja),
}