package com.example.mytictactoe

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var loadingScreen: LinearLayout
    private lateinit var clickToContinue: View
    private lateinit var loadBar: ProgressBar
    private lateinit var loadText: TextView
    private lateinit var tipTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        loadingScreen = findViewById(R.id.loadingScreen)
        clickToContinue = findViewById(R.id.clickToContinue)
        loadBar = findViewById(R.id.loadBar)
        loadText = findViewById(R.id.loadText)
        tipTextView = findViewById(R.id.tips)

        val tips = arrayOf(
            "Tip: Keep your mind clear and focused.",
            "Tip: Plan your moves ahead.",
            "Tip: Try to control the center of the board.",
            "Tip: Watch out for traps set by your opponent.",
            "Tip: Think defensively as well as offensively.",
            "Tip: Practice makes perfect.",
            "Tip: Mind your surroundings",
            "Tip: Do or do  not. There is no try",
            "Tip: The Greatest Teacher Failure is"
        )

        val randomTip = tips[Random.nextInt(tips.size)]
        tipTextView.text = randomTip

        button1.setOnClickListener {
            val intent = Intent(this, DifficultyActivity::class.java)
            startActivity(intent)
        }

        button2.setOnClickListener {
            val intent = Intent(this, DoublePlayer::class.java)
            startActivity(intent)
        }

        Handler(Looper.getMainLooper()).postDelayed({
            clickToContinue.visibility = View.VISIBLE
            loadBar.visibility = View.GONE
            loadText.visibility = View.GONE
        }, 7000) // 7-second delay

        loadingScreen.setOnClickListener {
            if (clickToContinue.visibility == View.VISIBLE) {
                loadingScreen.visibility = View.GONE
            }
        }
    }
}
