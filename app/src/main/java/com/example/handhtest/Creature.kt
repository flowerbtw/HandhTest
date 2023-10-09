package com.example.handhtest
import kotlin.random.Random

open class Creature(val name: String, val attack: Int, val defense: Int, val maxHealth: Int, var minDamage: Int, val maxDamage: Int) {
    var currentHealth: Int = maxHealth
    fun calculateAttackModifier(target: Creature): Int {
        val attackModifier = attack - target.defense + 1
        return if (attackModifier > 0) attackModifier else 1
    }
    fun calculateDamage(): Int {
        return Random.nextInt(minDamage, maxDamage)
    }
    fun dealDamage(target: Creature) {
        val attackModifier = calculateAttackModifier(target)
        val diceRolls = Array(attackModifier) { Random.nextInt(1, 7) }.sortedDescending()
        val success = diceRolls[0] >= 4

        if (success) {
            target.takeDamage()
        }
        else {
            println("Oops, miss!")
        }
    }
    open fun takeDamage() {
        currentHealth -= calculateDamage()
    }
}