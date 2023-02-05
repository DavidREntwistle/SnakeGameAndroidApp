package com.davidrentwistle.snakegame

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class GameActivity : AppCompatActivity() {

    private lateinit var exitGameButton: Button
    private lateinit var countdownTextView: TextView
    private lateinit var snakeGame: SnakeGame
    private lateinit var snakeImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        exitGameButton = findViewById(R.id.exit_game_button)
        countdownTextView = findViewById(R.id.countdown_text_view)
        snakeGame = SnakeGame()
        snakeImageView = findViewById(R.id.snake_image_view)

        exitGameButton.setOnClickListener {
            // Finish the GameActivity and return to the StartScreenActivity
            finish()
        }

        // Set the initial position of the snake
        val screenWidth = 50
        val screenHeight = 50
        snakeImageView.layoutParams.width = screenWidth
        snakeImageView.layoutParams.height = screenHeight
        snakeImageView.x = ((screenWidth / 2) - (snakeImageView.layoutParams.width / 2)).toFloat()
        snakeImageView.y = ((screenHeight / 2) - (snakeImageView.layoutParams.height / 2)).toFloat()
        snakeImageView.visibility = View.INVISIBLE

        object : CountDownTimer(4000, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                when (val secondsLeft = (millisUntilFinished / 1000).toInt()) {
                    in 2..3 -> countdownTextView.text = "$secondsLeft"
                    1 -> countdownTextView.text = "1"
                    0 -> countdownTextView.text = "Go!"
                }
            }

            override fun onFinish() {
                countdownTextView.visibility = View.GONE
                snakeImageView.visibility = View.VISIBLE
                snakeGame.start()
            }
        }.start()
    }
}