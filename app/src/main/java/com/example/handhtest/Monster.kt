package com.example.handhtest
import kotlin.random.Random

class Monster(attack: Int, defense: Int, health: Int) : Creature(attack, defense, health) {
    fun attackPlayer(player: Player) {
        val attackModifier = calculateAttackModifier(player)
        val success = (1..attackModifier).any { Random.nextInt(1, 7) >= 5 }
        if (success) {
            val damage = calculateDamage()
            player.takeDamage(damage)
        }
    }
}