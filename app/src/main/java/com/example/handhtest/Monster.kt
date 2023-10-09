package com.example.handhtest

class Monster(name: String, attack: Int, defense: Int, maxHealth: Int, minDamage: Int, maxDamage: Int) : Creature(name, attack, defense, maxHealth, minDamage, maxDamage) {
    override fun takeDamage() {
        super.takeDamage()
        if (currentHealth <= 0) {
            println("$name defeated")
        }
    }
}