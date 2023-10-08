package com.example.handhtest
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    fun main() {
        val player = Player(20, 15, 100)
        val monster = Monster(15, 10, 50)

        println("Player health: ${player.health}") // Player health: 100
        println("Monster health: ${monster.health}") // Monster health: 50

        monster.attackPlayer(player)

        println("Player health after attack: ${player.health}") // Player health after attack: 95
        println("Monster health after attack: ${monster.health}") // Monster health after attack: 50

        player.heal()

        println("Player health after healing: ${player.health}") // Player health after healing: 100
    }
}

fun main() {
    val mainActivity = MainActivity()
    mainActivity.main()
}