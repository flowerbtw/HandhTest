package com.example.handhtest

import android.widget.TextView

class Player(val gameActivity : GameActivity) : Creature("Knight", 20, 20, 100, 30, 50) {
    private var healCount = 0

    override fun takeDamage(damage: Int) {
        super.takeDamage(damage)
        if (currentHealth <= 0) {
            (gameActivity as? GameActivity)?.playerDied()
        }
    }

    fun heal(textMessageTextView: TextView) {
        val maxHealCount = 4
        val healPercent = 0.3

        if (currentHealth >= maxHealth) {
            textMessageTextView.text = "You are already full."
        } else {
            if (currentHealth > 0) {
                if (healCount < maxHealCount) {
                    val healAmount = (maxHealth * healPercent).toInt()
                    currentHealth += healAmount
                    if (currentHealth > maxHealth) {
                        currentHealth = maxHealth
                    }
                    textMessageTextView.text = "You healed $healAmount health units"
                    healCount++
                }
            }
            else textMessageTextView.text = "You already healed 4 times"
        }
    }
}
