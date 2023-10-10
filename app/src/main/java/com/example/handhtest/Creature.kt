package com.example.handhtest
import android.widget.TextView
import kotlin.random.Random

open class Creature(val name: String, val attack: Int, val defense: Int, val maxHealth: Int, var minDamage: Int, val maxDamage: Int) {
    var currentHealth: Int = maxHealth

    fun calculateAttackModifier(target: Creature): Int {
        val attackModifier = attack - target.defense + 1
        return if (attackModifier > 0) attackModifier else 1
    }
    fun calculateDamage(): Int {
        return Random.nextInt(minDamage, maxDamage + 1)
    }
    fun dealDamage(target: Creature, textMessageTextView: TextView) {
        val attackModifier = calculateAttackModifier(target)
        val diceRolls = Array(attackModifier) { Random.nextInt(1, 7) }.sortedDescending()
        val success = diceRolls[0] >= 4

        if (success) {
            val actualDamage = calculateDamage()
            target.takeDamage(actualDamage)
            textMessageTextView.text = "$name deals $actualDamage damage to the ${target.name}."
        }
        else {
            textMessageTextView.text = "Oops! $name missed"
        }
    }
    open fun takeDamage(damage: Int) {
        currentHealth -= damage
    }
}