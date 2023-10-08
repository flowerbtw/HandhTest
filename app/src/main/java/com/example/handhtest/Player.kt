package com.example.handhtest

class Player(attack: Int, defense: Int, health: Int) : Creature(attack, defense, health) {
    override fun heal() {
        if (health > 0) {
            super.heal()
        }
    }
}