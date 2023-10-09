package com.example.handhtest

class Player : Creature("Knight", 20, 20, 100, 30, 50) {
    fun heal() {
        val maxHealth = 100
        val maxHealCount = 4
        val healPercent = 0.3

        if (health > 0) {
            for (i in 1..maxHealCount) {
                if (health < maxHealth) {
                    val healAmount = (maxHealth * healPercent).toInt()
                    health += healAmount
                    if (health > maxHealth) {
                        health = maxHealth
                    }
                } else {
                    break
                }
            }
        }
    }
}