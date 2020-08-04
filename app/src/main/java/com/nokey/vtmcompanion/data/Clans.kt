package com.nokey.vtmcompanion.data

import androidx.annotation.StringRes
import com.nokey.vtmcompanion.R

enum class Clans(@StringRes val stringRes: Int) {
    BRUJAH(R.string.brujah),
    GANGREL(R.string.gangrel),
    MALKAVIAN(R.string.malkavian),
    NOSFERATU(R.string.nosferatu),
    TOREADOR(R.string.toreador),
    TREMERE(R.string.tremere),
    VENTRUE(R.string.ventrue),
    CAITIFF(R.string.caitiff),
    THIN_BLOOD(R.string.thin_blood),
}

enum class Attributes(val attributeType: AttributeType) { //}, @StringRes val nameRes: Int) {
    Strength(AttributeType.PHYSICAL), //R.string.strength),
    Dexterity(AttributeType.PHYSICAL), //R.string.dexterity),
    Stamina(AttributeType.PHYSICAL), //R.string.stamina),
    Charisma(AttributeType.SOCIAL), //R.string.charisma),
    Manipulation(AttributeType.SOCIAL), //R.string.manipulation),
    Composure(AttributeType.SOCIAL), //R.string.composure),
    Intelligence(AttributeType.MENTAL), //R.string.intelligence),
    Wits(AttributeType.MENTAL), //R.string.wits),
    Resolve(AttributeType.MENTAL) //R.string.resolve)
}

enum class AttributeType{
    PHYSICAL,
    SOCIAL,
    MENTAL
}

enum class Skills {
    DEFAULT,
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