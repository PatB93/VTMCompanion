package com.nokey.vtmcompanion.data

import androidx.annotation.StringRes
import com.nokey.vtmcompanion.R

enum class Clan(@StringRes val stringRes: Int, disciplineOptions: List<Discipline>) {
    BRUJAH(R.string.brujah, listOf(Discipline.CELERITY, Discipline.POTENCE, Discipline.PRESENCE)),
    GANGREL(
        R.string.gangrel,
        listOf(Discipline.ANIMALISM, Discipline.FORTITUDE, Discipline.PROTEAN)
    ),
    MALKAVIAN(
        R.string.malkavian,
        listOf(Discipline.AUSPEX, Discipline.DEMENTATION, Discipline.OBFUSCATE)
    ),
    NOSFERATU(
        R.string.nosferatu,
        listOf(Discipline.ANIMALISM, Discipline.OBFUSCATE, Discipline.POTENCE)
    ),
    TOREADOR(
        R.string.toreador,
        listOf(Discipline.AUSPEX, Discipline.CELERITY, Discipline.PRESENCE)
    ),
    TREMERE(
        R.string.tremere,
        listOf(Discipline.AUSPEX, Discipline.DOMINATE, Discipline.THAUMATURGY)
    ),
    VENTRUE(
        R.string.ventrue,
        listOf(Discipline.DOMINATE, Discipline.FORTITUDE, Discipline.PRESENCE)
    ),
    CAITIFF(
        R.string.caitiff,
        listOf(
            Discipline.CELERITY,
            Discipline.POTENCE,
            Discipline.PRESENCE,
            Discipline.ANIMALISM,
            Discipline.FORTITUDE,
            Discipline.PROTEAN,
            Discipline.DOMINATE,
            Discipline.OBTENEBRATION,
            Discipline.AUSPEX,
            Discipline.DEMENTATION,
            Discipline.OBFUSCATE,
            Discipline.THAUMATURGY,
            Discipline.VICISSITUDE
        )
    ),
    THIN_BLOOD(
        R.string.thin_blood,
        listOf(Discipline.THIN_BLOOD_ALCHEMY)
    ),
    LASOMBRA(
        R.string.lasombra,
        listOf(Discipline.DOMINATE, Discipline.OBTENEBRATION, Discipline.POTENCE)
    ),
    TZIMISCE(
        R.string.tzimisce,
        listOf(Discipline.ANIMALISM, Discipline.AUSPEX, Discipline.VICISSITUDE)
    )
}

enum class Attributes(
    var dotsAssigned: Short,
    val attributeType: AttributeType,
    @StringRes val nameRes: Int
) {
    Strength(0, AttributeType.PHYSICAL, R.string.strength),
    Dexterity(0, AttributeType.PHYSICAL, R.string.dexterity),
    Stamina(0, AttributeType.PHYSICAL, R.string.stamina),
    Charisma(0, AttributeType.SOCIAL, R.string.charisma),
    Manipulation(0, AttributeType.SOCIAL, R.string.manipulation),
    Composure(0, AttributeType.SOCIAL, R.string.composure),
    Intelligence(0, AttributeType.MENTAL, R.string.intelligence),
    Wits(0, AttributeType.MENTAL, R.string.wits),
    Resolve(0, AttributeType.MENTAL, R.string.resolve)
}

enum class AttributeType {
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

enum class Discipline {
    CELERITY,
    POTENCE,
    PRESENCE,
    ANIMALISM,
    FORTITUDE,
    PROTEAN,
    DOMINATE,
    OBTENEBRATION,
    AUSPEX,
    DEMENTATION,
    OBFUSCATE,
    THAUMATURGY,
    VICISSITUDE,
    THIN_BLOOD_ALCHEMY
}
