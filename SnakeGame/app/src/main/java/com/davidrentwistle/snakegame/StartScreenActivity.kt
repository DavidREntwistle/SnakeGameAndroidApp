package com.davidrentwistle.snakegame

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class StartScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        val startGameButton = findViewById<Button>(R.id.start_game_button)
        startGameButton.setOnClickListener {
            startActivity(Intent(this, GameActivity::class.java))
        }

        val leaderboardButton = findViewById<Button>(R.id.leaderboard_button)
        leaderboardButton.setOnClickListener {
            startActivity(Intent(this, LeaderboardActivity::class.java))
        }
    }
}
