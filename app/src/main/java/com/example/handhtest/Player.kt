package com.example.handhtest

class Player : Creature("Knight", 20, 20, 100, 30, 50) {
    override fun takeDamage() {
        super.takeDamage()
        if (currentHealth <= 0) {
            println("The game is over. You are dead")
        }
    }
    fun heal() {
        val maxHealCount = 4
        val healPercent = 0.3

        if (currentHealth > 0) {
            for (i in 1..maxHealCount) {
                if (currentHealth < maxHealth) {
                    val healAmount = (maxHealth * healPercent).toInt()
                    currentHealth += healAmount
                    if (currentHealth > maxHealth) {
                        currentHealth = maxHealth
                    }
                    println("You are healed by $healAmount health units")
                } else {
                    println("You are already completely healthy")
                }
            }
        }
    }
}