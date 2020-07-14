package com.nokey.vtmcompanion.data

import androidx.annotation.StringRes
import com.nokey.vtmcompanion.R

enum class Clans(@StringRes val stringRes: Int) {
    NOSFERATU(R.string.nosferatu),
    VENTRUE(R.string.ventrue),
    TOREADOR(R.string.toreador),
    BRUJA(R.string.bruja),
}

enum class Attributes(attributeType: AttributeType) {
    STRENGTH(AttributeType.PHYSICAL),
    DEXTERITY(AttributeType.PHYSICAL),
    STAMINA(AttributeType.PHYSICAL),
    CHARISMA(AttributeType.SOCIAL),
    MANIPULATION(AttributeType.SOCIAL),
    COMPOSURE(AttributeType.SOCIAL),
    INTELLIGENCE(AttributeType.MENTAL),
    WITS(AttributeType.MENTAL),
    RESOLVE(AttributeType.MENTAL)
}

enum class AttributeType{
    PHYSICAL,
    SOCIAL,
    MENTAL
}

enum class Skills {
    ATHLETICS,
    BRAWL,
    CRAFT,
    DRIVE,
    FIREARMS,
    LARCENY,
    MELEE,
    STEALTH,
    SURVIVAL,
    ANIMAL_KEN,
    ETIQUETTE,
    INSIGHT,
    INTIMIDATION,
    LEADERSHIP,
    PERFORMANCE,
    PERSUASION,
    STREETWISE,
    SUBTERFUGE,
    ACADEMICS,
    AWARENESS,
    FINANCE,
    INVESTIGATION,
    MEDICINE,
    OCCULT,
    POLITICS,
    SCIENCE,
    TECHNOLOGY
}