package com.example.handhtest
import kotlin.random.Random

open class Creature(val attack: Int, val defense: Int, var health: Int) {
    init {
        require(attack in 1..30 && defense in 1..30 && health in 0..100) {
            "Invalid creature parameters"
        }
    }

    open fun calculateAttackModifier(target: Creature): Int {
        return attack - target.defense + 1
    }

    open fun calculateDamage(): Int {
        return Random.nextInt(1, 7)
    }

    open fun takeDamage(damage: Int) {
        health -= damage
        if (health < 0) {
            health = 0
        }
    }

    open fun heal() {
        if (health > 0) {
            health += (health * 0.3).toInt()
            if (health > 100) {
                health = 100
            }
        }
    }
}