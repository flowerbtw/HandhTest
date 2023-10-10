package com.example.handhtest

class Monster(name: String, attack: Int, defense: Int, maxHealth: Int, minDamage: Int, maxDamage: Int) : Creature(name, attack, defense, maxHealth, minDamage, maxDamage) {
    private var onMonsterDefeatedCallback: (() -> Unit)? = null

    fun setOnMonsterDefeatedCallback(callback: () -> Unit) {
        onMonsterDefeatedCallback = callback
    }
    override fun takeDamage(damage: Int) {
        super.takeDamage(damage)
        if (currentHealth <= 0) {
            onMonsterDefeatedCallback?.invoke()
        }
    }
}