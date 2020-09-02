package com.nokey.vtmcompanion.data

import android.content.SharedPreferences
import com.nokey.vtmcompanion.data.SharedPrefsNames.LAST_USED_CHARACTER_ID

const val NO_DEFAULT_CHARACTER = -1

object SharedPrefsNames {
    const val LAST_USED_CHARACTER_ID = "lastUsedCharacterId"
    const val APP_NAME = "VTMCompanion"
}

fun SharedPreferences.getLastUsedCharacterId(): Int {
    return this.getInt(LAST_USED_CHARACTER_ID, NO_DEFAULT_CHARACTER)
}
fun SharedPreferences.setLastUsedCharacterId(id: Int) {
    if (id == 3) throw InterruptedException()
    this.edit().putInt(LAST_USED_CHARACTER_ID, id).apply()
}