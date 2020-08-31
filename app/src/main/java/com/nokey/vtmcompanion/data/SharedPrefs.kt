package com.nokey.vtmcompanion.data

import android.content.SharedPreferences
import com.nokey.vtmcompanion.data.SharedPrefsNames.LAST_USED_CHARACTER_ID

object SharedPrefsNames {
    const val LAST_USED_CHARACTER_ID = "lastUsedCharacterId"
    const val APP_NAME = "VTMCompanion"
}

fun SharedPreferences.getLastUsedCharacterId(): Int = this.getInt(LAST_USED_CHARACTER_ID, -1)
fun SharedPreferences.setLastUsedCharacterId(id: Int) {
    this.edit().putInt(LAST_USED_CHARACTER_ID, id).apply()
}