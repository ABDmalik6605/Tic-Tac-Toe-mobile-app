package com.example.mytictactoe

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class DifficultyActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_difficulty)

        val myButton1 = findViewById<Button>(R.id.myButton)
        val myButton2 = findViewById<Button>(R.id.myButton2)
        val myButton3 = findViewById<Button>(R.id.myButton3)

        val animator1 = ObjectAnimator.ofFloat(myButton1, "translationX", 1000f, 0f)
        animator1.duration = 1000
        animator1.start()
        val animator2 = ObjectAnimator.ofFloat(myButton2, "translationX", -1000f, 0f)
        animator2.duration = 1000
        animator2.start()
        val animator3 = ObjectAnimator.ofFloat(myButton3, "translationX", 1000f, 0f)
        animator3.duration = 1000
        animator3.start()
        myButton1.setOnClickListener {
            val intent = Intent(this, OpponentActivity::class.java)
            intent.putExtra("EXTRA_INTEGER", 1)
            startActivity(intent)
        }
        myButton2.setOnClickListener {
            val intent = Intent(this, OpponentActivity::class.java)
            intent.putExtra("EXTRA_INTEGER", 2)
            startActivity(intent)
        }
        myButton3.setOnClickListener {
            val intent = Intent(this, OpponentActivity::class.java)
            intent.putExtra("EXTRA_INTEGER", 3)
            startActivity(intent)
        }
    }
}