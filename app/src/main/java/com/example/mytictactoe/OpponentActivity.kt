package com.example.mytictactoe

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
class OpponentActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opponent)
        val intent = intent
        val difficultyLevel = intent.getIntExtra("EXTRA_INTEGER", 2)
        val myButton1 = findViewById<Button>(R.id.opponent1)
        val myButton2 = findViewById<Button>(R.id.opponent2)
        val myButton3 = findViewById<Button>(R.id.opponent3)

        myButton1.setOnClickListener {
            val intent = Intent(this, SinglePlayer::class.java)
            intent.putExtra("EXTRA_INTEGER", 1)
            intent.putExtra("EXTRA_DIFFICULTY", difficultyLevel)
            startActivity(intent)
        }
        myButton2.setOnClickListener {
            val intent = Intent(this, SinglePlayer::class.java)
            intent.putExtra("EXTRA_INTEGER", 2)
            intent.putExtra("EXTRA_DIFFICULTY", difficultyLevel)
            startActivity(intent)
        }
        myButton3.setOnClickListener {
            val intent = Intent(this, SinglePlayer::class.java)
            intent.putExtra("EXTRA_INTEGER", 3)
            intent.putExtra("EXTRA_DIFFICULTY", difficultyLevel)
            startActivity(intent)
        }
    }
}