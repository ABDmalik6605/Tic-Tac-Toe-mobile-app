package com.example.mytictactoe

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.constraintlayout.widget.ConstraintLayout


class DoublePlayer : AppCompatActivity() {
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button
    private lateinit var result: TextView
    private lateinit var result2: TextView
    private lateinit var turn: TextView
    private lateinit var verticalLineRed1: TextView
    private lateinit var verticalLineRed2: TextView
    private lateinit var verticalLineRed3: TextView
    private lateinit var verticalLineBlue1: TextView
    private lateinit var verticalLineBlue2: TextView
    private lateinit var verticalLineBlue3: TextView
    private lateinit var horizontalLineRed1: TextView
    private lateinit var horizontalLineRed2: TextView
    private lateinit var horizontalLineRed3: TextView
    private lateinit var horizontalLineBlue1: TextView
    private lateinit var horizontalLineBlue2: TextView
    private lateinit var horizontalLineBlue3: TextView
    private lateinit var leftdiagonalred: ImageView
    private lateinit var rightdiagonalred: ImageView
    private lateinit var leftdiagonalblue: ImageView
    private lateinit var rightdiagonalblue: ImageView
    private lateinit var layout: ConstraintLayout

    private var game: Boolean = false
    private var choose: Int = 0
    private var boolArray: BooleanArray = BooleanArray(9)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.double_player)
        initUI()
        setListeners()
    }
    private fun initUI(){
        button1=findViewById(R.id.button1)
        button2=findViewById(R.id.button2)
        button3=findViewById(R.id.button3)
        button4=findViewById(R.id.button4)
        button5=findViewById(R.id.button5)
        button6=findViewById(R.id.button6)
        button7=findViewById(R.id.button7)
        button8=findViewById(R.id.button8)
        button9=findViewById(R.id.button9)
        result=findViewById(R.id.result)
        result2=findViewById(R.id.result2)
        verticalLineRed1=findViewById(R.id.verticalLineRed1)
        verticalLineRed2=findViewById(R.id.verticalLineRed2)
        verticalLineRed3=findViewById(R.id.verticalLineRed3)
        verticalLineBlue1=findViewById(R.id.verticalLineBlue1)
        verticalLineBlue2=findViewById(R.id.verticalLineBlue2)
        verticalLineBlue3=findViewById(R.id.verticalLineBlue3)
        horizontalLineRed1=findViewById(R.id.HorizontalLineRed1)
        horizontalLineRed2=findViewById(R.id.HorizontalLineRed2)
        horizontalLineRed3=findViewById(R.id.HorizontalLineRed3)
        horizontalLineBlue1=findViewById(R.id.HorizontalLineBlue1)
        horizontalLineBlue2=findViewById(R.id.HorizontalLineBlue2)
        horizontalLineBlue3=findViewById(R.id.HorizontalLineBlue3)
        leftdiagonalred=findViewById(R.id.leftDiagonalRed)
        rightdiagonalred=findViewById(R.id.rightDiagonalRed)
        leftdiagonalblue=findViewById(R.id.leftDiagonalBlue)
        rightdiagonalblue=findViewById(R.id.rightDiagonalBlue)
        layout = findViewById(R.id.main)
        turn=findViewById(R.id.turn)
        turn.text="Player 1 turn"
        turn.setTextColor(ContextCompat.getColor(this, R.color.red))
    }
    private fun setBackgroundImage(imageResId: Int) {
        layout.setBackgroundResource(imageResId)
    }
    private fun checkwin(){
        if (button1.text!="" && button1.text==button2.text && button1.text==button3.text)
        {
            result.text="CONGRATULATIONS!"
            if (button1.text=="X") {
                result2.text = "Player 1"
                result.setTextColor(ContextCompat.getColor(this, R.color.red))
                result2.setTextColor(ContextCompat.getColor(this, R.color.red))
                horizontalLineRed1.visibility=View.VISIBLE
                setBackgroundImage(R.drawable.player1win)
            }
            else if (button1.text=="O") {
                result2.text = "Player 2"
                result.setTextColor(ContextCompat.getColor(this, R.color.blue))
                result2.setTextColor(ContextCompat.getColor(this, R.color.blue))
                horizontalLineBlue1.visibility=View.VISIBLE
                setBackgroundImage(R.drawable.player2win)
            }
            game=true
            turn.text=""
        }
        if (button4.text!="" && button4.text==button5.text && button4.text==button6.text)
        {
            result.text="CONGRATULATIONS!"
            if (button4.text=="X") {
                result2.text = "Player 1"
                result.setTextColor(ContextCompat.getColor(this, R.color.red))
                result2.setTextColor(ContextCompat.getColor(this, R.color.red))
                horizontalLineRed2.visibility=View.VISIBLE
                setBackgroundImage(R.drawable.player1win)
            }
            else if (button4.text=="O") {
                result2.text = "Player 2"
                result.setTextColor(ContextCompat.getColor(this, R.color.blue))
                result2.setTextColor(ContextCompat.getColor(this, R.color.blue))
                horizontalLineBlue2.visibility=View.VISIBLE
                setBackgroundImage(R.drawable.player2win)
            }
            game=true
            turn.text=""
        }
        if (button7.text!="" && button7.text==button8.text && button7.text==button9.text)
        {
            result.text="CONGRATULATIONS!"
            if (button7.text=="X") {
                result2.text = "Player 1"
                result.setTextColor(ContextCompat.getColor(this, R.color.red))
                result2.setTextColor(ContextCompat.getColor(this, R.color.red))
                horizontalLineRed3.visibility=View.VISIBLE
                setBackgroundImage(R.drawable.player1win)
            }
            else if (button7.text=="O") {
                result2.text = "Player 2"
                result.setTextColor(ContextCompat.getColor(this, R.color.blue))
                result2.setTextColor(ContextCompat.getColor(this, R.color.blue))
                horizontalLineBlue3.visibility=View.VISIBLE
                setBackgroundImage(R.drawable.player2win)
            }
            game=true
            turn.text=""
        }

        if (button1.text!="" && button1.text==button4.text && button1.text==button7.text)
        {
            result.text="CONGRATULATIONS!"
            if (button1.text=="X") {
                result2.text = "Player 1"
                result.setTextColor(ContextCompat.getColor(this, R.color.red))
                result2.setTextColor(ContextCompat.getColor(this, R.color.red))
                verticalLineRed1.visibility= View.VISIBLE
                setBackgroundImage(R.drawable.player1win)
            }
            else if (button1.text=="O") {
                result2.text = "Player 2"
                result.setTextColor(ContextCompat.getColor(this, R.color.blue))
                result2.setTextColor(ContextCompat.getColor(this, R.color.blue))
                verticalLineBlue1.visibility=View.VISIBLE
                setBackgroundImage(R.drawable.player2win)
            }
            game=true
            turn.text=""
        }
        if (button2.text!="" && button2.text==button5.text && button2.text==button8.text)
        {
            result.text="CONGRATULATIONS!"
            if (button2.text=="X") {
                result2.text = "Player 1"
                result.setTextColor(ContextCompat.getColor(this, R.color.red))
                result2.setTextColor(ContextCompat.getColor(this, R.color.red))
                verticalLineRed2.visibility= View.VISIBLE
                setBackgroundImage(R.drawable.player1win)
            }
            else if (button2.text=="O") {
                result2.text = "Player 2"
                result.setTextColor(ContextCompat.getColor(this, R.color.blue))
                result2.setTextColor(ContextCompat.getColor(this, R.color.blue))
                verticalLineBlue2.visibility=View.VISIBLE
                setBackgroundImage(R.drawable.player2win)
            }
            game=true
            turn.text=""
        }
        if (button3.text!="" && button3.text==button6.text && button3.text==button9.text)
        {
            result.text="CONGRATULATIONS!"
            if (button3.text=="X") {
                result2.text = "Player 1"
                result.setTextColor(ContextCompat.getColor(this, R.color.red))
                result2.setTextColor(ContextCompat.getColor(this, R.color.red))
                verticalLineRed3.visibility= View.VISIBLE
                setBackgroundImage(R.drawable.player1win)
            }
            else if (button3.text=="O") {
                result2.text = "Player 2"
                result.setTextColor(ContextCompat.getColor(this, R.color.blue))
                result2.setTextColor(ContextCompat.getColor(this, R.color.blue))
                verticalLineBlue3.visibility=View.VISIBLE
                setBackgroundImage(R.drawable.player2win)
            }
            game=true
            turn.text=""
        }

        if (button1.text!="" && button1.text==button5.text && button1.text==button9.text)
        {
            result.text="CONGRATULATIONS!"
            if (button1.text=="X") {
                result2.text = "Player 1"
                result.setTextColor(ContextCompat.getColor(this, R.color.red))
                result2.setTextColor(ContextCompat.getColor(this, R.color.red))
                rightdiagonalred.visibility=View.VISIBLE
                setBackgroundImage(R.drawable.player1win)
            }
            else if (button1.text=="O") {
                result2.text = "Player 2"
                result.setTextColor(ContextCompat.getColor(this, R.color.blue))
                result2.setTextColor(ContextCompat.getColor(this, R.color.blue))
                rightdiagonalblue.visibility=View.VISIBLE
                setBackgroundImage(R.drawable.player2win)
            }
            game=true
            turn.text=""
        }
        if (button3.text!="" && button3.text==button5.text && button3.text==button7.text)
        {
            result.text="CONGRATULATIONS!"
            if (button3.text=="X") {
                result2.text = "Player 1"
                result.setTextColor(ContextCompat.getColor(this, R.color.red))
                result2.setTextColor(ContextCompat.getColor(this, R.color.red))
                leftdiagonalred.visibility=View.VISIBLE
                setBackgroundImage(R.drawable.player1win)
            }
            else if (button3.text=="O") {
                result2.text = "Player 2"
                result.setTextColor(ContextCompat.getColor(this, R.color.blue))
                result2.setTextColor(ContextCompat.getColor(this, R.color.blue))
                leftdiagonalblue.visibility=View.VISIBLE
                setBackgroundImage(R.drawable.player2win)
            }
            game=true
            turn.text=""
        }
        checkdraw()
    }
    private fun checkdraw(){
        if (!game)
        {
            var draw=true
            for (i in boolArray)
            {
                if (i==false)
                    draw=false
            }
            if (draw==true) {
                result.text = "Match Drawn"
                result2.text = "Well played Both!"
                game = true
                turn.text = ""
            }
        }
    }
    private fun setListeners(){
        button1.setOnClickListener{
            if (!boolArray[0] && !game) {
                if (choose % 2 == 0) {
                    button1.text = "X"
                    button1.setTextColor(ContextCompat.getColor(this,R.color.red))
                    turn.text="Player 2 turn"
                    turn.setTextColor(ContextCompat.getColor(this, R.color.blue))
                } else {
                    button1.text = "O"
                    button1.setTextColor(ContextCompat.getColor(this,R.color.blue))
                    turn.text="Player 1 turn"
                    turn.setTextColor(ContextCompat.getColor(this, R.color.red))
                }
                choose++
                boolArray[0]=true
                checkwin()
            }
        }
        button2.setOnClickListener{
            if (!boolArray[1] && !game) {
                if (choose % 2 == 0) {
                    button2.text = "X"
                    button2.setTextColor(ContextCompat.getColor(this,R.color.red))
                    turn.text="Player 2 turn"
                    turn.setTextColor(ContextCompat.getColor(this, R.color.blue))
                } else {
                    button2.text = "O"
                    button2.setTextColor(ContextCompat.getColor(this,R.color.blue))
                    turn.text="Player 1 turn"
                    turn.setTextColor(ContextCompat.getColor(this, R.color.red))
                }
                choose++
                boolArray[1]=true
                checkwin()
            }
        }
        button3.setOnClickListener{
            if (!boolArray[2] && !game) {
                if (choose % 2 == 0) {
                    button3.text = "X"
                    button3.setTextColor(ContextCompat.getColor(this,R.color.red))
                    turn.text="Player 2 turn"
                    turn.setTextColor(ContextCompat.getColor(this, R.color.blue))
                } else {
                    button3.text = "O"
                    button3.setTextColor(ContextCompat.getColor(this,R.color.blue))
                    turn.text="Player 1 turn"
                    turn.setTextColor(ContextCompat.getColor(this, R.color.red))
                }
                choose++
                boolArray[2] = true
                checkwin()
            }
        }

        button4.setOnClickListener{
            if (!boolArray[3] && !game) {
                if (choose % 2 == 0) {
                    button4.text = "X"
                    button4.setTextColor(ContextCompat.getColor(this,R.color.red))
                    turn.text="Player 2 turn"
                    turn.setTextColor(ContextCompat.getColor(this, R.color.blue))
                } else {
                    button4.text = "O"
                    button4.setTextColor(ContextCompat.getColor(this,R.color.blue))
                    turn.text="Player 1 turn"
                    turn.setTextColor(ContextCompat.getColor(this, R.color.red))
                }
                choose++
                boolArray[3] = true
                checkwin()
            }
        }
        button5.setOnClickListener{
            if (!boolArray[4] && !game) {
                if (choose % 2 == 0) {
                    button5.text = "X"
                    button5.setTextColor(ContextCompat.getColor(this,R.color.red))
                    turn.text="Player 2 turn"
                    turn.setTextColor(ContextCompat.getColor(this, R.color.blue))
                } else {
                    button5.text = "O"
                    button5.setTextColor(ContextCompat.getColor(this,R.color.blue))
                    turn.text="Player 1 turn"
                    turn.setTextColor(ContextCompat.getColor(this, R.color.red))
                }
                choose++
                boolArray[4] = true
                checkwin()
            }
        }
        button6.setOnClickListener{
            if (!boolArray[5] && !game) {
                if (choose % 2 == 0) {
                    button6.text = "X"
                    button6.setTextColor(ContextCompat.getColor(this,R.color.red))
                    turn.text="Player 2 turn"
                    turn.setTextColor(ContextCompat.getColor(this, R.color.blue))
                } else {
                    button6.text = "O"
                    button6.setTextColor(ContextCompat.getColor(this,R.color.blue))
                    turn.text="Player 1 turn"
                    turn.setTextColor(ContextCompat.getColor(this, R.color.red))
                }
                choose++
                boolArray[5] = true
                checkwin()
            }
        }

        button7.setOnClickListener{
            if (!boolArray[6] && !game) {
                if (choose % 2 == 0) {
                    button7.text = "X"
                    button7.setTextColor(ContextCompat.getColor(this,R.color.red))
                    turn.text="Player 2 turn"
                    turn.setTextColor(ContextCompat.getColor(this, R.color.blue))
                } else {
                    button7.text = "O"
                    button7.setTextColor(ContextCompat.getColor(this,R.color.blue))
                    turn.text="Player 1 turn"
                    turn.setTextColor(ContextCompat.getColor(this, R.color.red))
                }
                choose++
                boolArray[6] = true
                checkwin()
            }
        }
        button8.setOnClickListener{
            if (!boolArray[7] && !game) {
                if (choose % 2 == 0) {
                    button8.text = "X"
                    button8.setTextColor(ContextCompat.getColor(this,R.color.red))
                    turn.text="Player 2 turn"
                    turn.setTextColor(ContextCompat.getColor(this, R.color.blue))
                } else {
                    button8.text = "O"
                    button8.setTextColor(ContextCompat.getColor(this,R.color.blue))
                    turn.text="Player 1 turn"
                    turn.setTextColor(ContextCompat.getColor(this, R.color.red))
                }
                choose++
                boolArray[7] = true
                checkwin()
            }
        }
        button9.setOnClickListener{
            if (!boolArray[8] && !game) {
                if (choose % 2 == 0) {
                    button9.text = "X"
                    button9.setTextColor(ContextCompat.getColor(this,R.color.red))
                    turn.text="Player 2 turn"
                    turn.setTextColor(ContextCompat.getColor(this, R.color.blue))
                } else {
                    button9.text = "O"
                    button9.setTextColor(ContextCompat.getColor(this,R.color.blue))
                    turn.text="Player 1 turn"
                    turn.setTextColor(ContextCompat.getColor(this, R.color.red))
                }
                choose++
                boolArray[8] = true
                checkwin()
            }
        }
    }
}