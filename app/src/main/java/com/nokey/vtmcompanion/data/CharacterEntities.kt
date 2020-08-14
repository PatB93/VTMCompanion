package com.nokey.vtmcompanion.data

import androidx.room.Entity

@Entity
data class Character(
    val sireName: String,
    val selectedClan: Clans,
    val skills: SkillDistributions,
    val attributes: MutableMap<Attributes, Short>
)