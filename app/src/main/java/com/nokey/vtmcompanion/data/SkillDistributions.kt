package com.nokey.vtmcompanion.data

class Balanced : SkillDistributions(0, 3, 5, 7)
class JackOfAllTrades : SkillDistributions(0, 1, 8, 10)
class Specialist : SkillDistributions(1, 3, 3, 3)


abstract class SkillDistributions(fourDot: Int, threeDot: Int, twoDot: Int, oneDot: Int) {
    val fourDotSkills = Array(fourDot) { Skills.DEFAULT }
    val threeDotSkills = Array(threeDot) { Skills.DEFAULT }
    val twoDotSkills = Array(twoDot) { Skills.DEFAULT }
    val oneDotSkills = Array(oneDot) { Skills.DEFAULT }
}