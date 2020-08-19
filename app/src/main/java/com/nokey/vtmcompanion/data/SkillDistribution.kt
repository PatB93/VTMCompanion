package com.nokey.vtmcompanion.data

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
class SkillDistribution(fourDot: Int, threeDot: Int, twoDot: Int, oneDot: Int) {
    val fourDotSkills = Array(fourDot) { Skills.DEFAULT }
    val threeDotSkills = Array(threeDot) { Skills.DEFAULT }
    val twoDotSkills = Array(twoDot) { Skills.DEFAULT }
    val oneDotSkills = Array(oneDot) { Skills.DEFAULT }
}

enum class DistributionTypes(val distribution: SkillDistribution) {
    Balanced(SkillDistribution(0, 3, 5, 7)),
    JackOfAllTrades(SkillDistribution(0, 1, 8, 10)),
    Specialist(SkillDistribution(1, 3, 3, 3))
}