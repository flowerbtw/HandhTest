package com.example.handhtest
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    private lateinit var fightButton: Button
    private lateinit var textMessageView: TextView

    private var isGamePlayed: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fightButton = findViewById(R.id.fightButton)
        textMessageView = findViewById(R.id.textMessageView)

        fightButton.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            startActivityForResult(intent, GAME_ACTIVITY_REQUEST_CODE)
        }

        if (isGamePlayed) {
            textMessageView.text = "Get ready to rise again! In Mobile Souls, death is just the beginning. Every defeat is a chance to learn, to adapt, and to emerge stronger. Embrace the challenge, test your determination, and conquer the unforgiving world that awaits. Forge your own path, overcome insurmountable odds, and discover the sweet taste of victory that comes after countless failures. Are you ready to face the abyss once more?"
        } else {
            textMessageView.text = "Welcome to the Mobile Souls, where dangers, dark secrets, and powerful enemies await you. Prepare for a treacherous journey, where your survival relies on battles, skill improvement, and overcoming challenges. Guide your character through gloomy locations and uncover ancient mysteries. Are you ready for this challenge? Mobile Souls awaits you."
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == GAME_ACTIVITY_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                isGamePlayed = true
            }
        }
    }

    companion object {
        const val GAME_ACTIVITY_REQUEST_CODE = 1
    }
}