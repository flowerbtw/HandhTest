package com.example.handhtest

class Monster(name: String, attack: Int, defense: Int, maxHealth: Int, minDamage: Int, maxDamage: Int) : Creature(name, attack, defense, maxHealth, minDamage, maxDamage) {
    override fun takeDamage(damage: Int) {
        super.takeDamage(damage)
        if (currentHealth <= 0) {
            println("$name defeated")
        }
    }
}