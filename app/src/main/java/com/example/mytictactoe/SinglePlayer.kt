package com.example.mytictactoe

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import kotlin.random.Random

class SinglePlayer : AppCompatActivity() {
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
    private var difficulty: Int = 2
    private var opponent: Int = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.single_player)
        val intent = intent
        difficulty = intent.getIntExtra("EXTRA_DIFFICULTY", 2)
        opponent = intent.getIntExtra("EXTRA_INTEGER", 0)
        initUI()
        setListeners()
    }
    private fun setBackgroundImage(imageResId: Int) {
        layout.setBackgroundResource(imageResId)
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
        turn=findViewById(R.id.turn)
        //button5.text="X"
        //boolArray[4]=true
        turn.text="Make your move"
        turn.setTextColor(ContextCompat.getColor(this, R.color.white))
        layout = findViewById(R.id.main)
        if (opponent==1)
            setBackgroundImage(R.drawable.sukuna2)
        else if (opponent==2)
            setBackgroundImage(R.drawable.vader2)
        else if (opponent==3)
            setBackgroundImage(R.drawable.skynet2)

    }
    private fun checkwin(){
        if (button1.text!="" && button1.text==button2.text && button1.text==button3.text)
        {
            if (button1.text=="X") {
                horizontalLineRed1.visibility=View.VISIBLE
                if (opponent==1){
                    result.text="You are defeated!"
                    result2.text = "But Stand proud,\nyou are strong"
                    setBackgroundImage(R.drawable.sukunawin)
                }
                else if (opponent==2) {
                    result.text="Defeated you are!"
                    result2.text = "It's over. I have the high ground"
                    setBackgroundImage(R.drawable.vaderwin)
                }
                else if (opponent==3) {
                    result.text="Skynet has won!"
                    result2.text = "You are defeated human as\nyou were destined to"
                    setBackgroundImage(R.drawable.skynetwin)
                }
            }
            else if (button1.text=="O") {
                horizontalLineBlue1.visibility=View.VISIBLE
                result.text="Congratulations!"
                if (opponent==1){
                    result2.text = "You have defeated the\n king of curses"
                    setBackgroundImage(R.drawable.sukunalose)
                }
                else if (opponent==2) {
                    result2.text = "Defeated the Dark side you have.May the force be with you"
                    setBackgroundImage(R.drawable.vaderlose)
                }
                else if (opponent==3) {
                    result2.text = "You have saved John connor\nand stopped Skynet"
                    setBackgroundImage(R.drawable.skynetlose)
                }
            }
            game=true
            turn.text=""
        }
        if (button4.text!="" && button4.text==button5.text && button4.text==button6.text)
        {
            if (button4.text=="X") {
                horizontalLineRed2.visibility=View.VISIBLE
                if (opponent==1){
                    result.text="You are defeated!"
                    result2.text = "But Stand proud,\nyou are strong"
                    setBackgroundImage(R.drawable.sukunawin)
                }
                else if (opponent==2) {
                    result.text="Defeated you are!"
                    result2.text = "It's over. I have the high ground"
                    setBackgroundImage(R.drawable.vaderwin)
                }
                else if (opponent==3) {
                    result.text="Skynet has won!"
                    result2.text = "You are defeated human as\nyou were destined to"
                    setBackgroundImage(R.drawable.skynetwin)
                }
            }
            else if (button4.text=="O") {
                horizontalLineBlue2.visibility=View.VISIBLE
                result.text="Congratulations!"
                if (opponent==1){
                    result2.text = "You have defeated the\n king of curses"
                    setBackgroundImage(R.drawable.sukunalose)
                }
                else if (opponent==2) {
                    result2.text = "Defeated the Dark side you have.May the force be with you"
                    setBackgroundImage(R.drawable.vaderlose)
                }
                else if (opponent==3) {
                    result2.text = "You have saved John connor\nand stopped Skynet"
                    setBackgroundImage(R.drawable.skynetlose)
                }
            }
            game=true
            turn.text=""
        }
        if (button7.text!="" && button7.text==button8.text && button7.text==button9.text)
        {
            if (button7.text=="X") {
                horizontalLineRed3.visibility=View.VISIBLE
                if (opponent==1){
                    result.text="You are defeated!"
                    result2.text = "But Stand proud,\nyou are strong"
                    setBackgroundImage(R.drawable.sukunawin)
                }
                else if (opponent==2) {
                    result.text="Defeated you are!"
                    result2.text = "It's over. I have the high ground"
                    setBackgroundImage(R.drawable.vaderwin)
                }
                else if (opponent==3) {
                    result.text="Skynet has won!"
                    result2.text = "You are defeated human as\nyou were destined to"
                    setBackgroundImage(R.drawable.skynetwin)
                }
            }
            else if (button7.text=="O") {
                horizontalLineBlue3.visibility=View.VISIBLE
                result.text="Congratulations!"
                if (opponent==1){
                    result2.text = "You have defeated the\n king of curses"
                    setBackgroundImage(R.drawable.sukunalose)
                }
                else if (opponent==2) {
                    result2.text = "Defeated the Dark side you have.May the force be with you"
                    setBackgroundImage(R.drawable.vaderlose)
                }
                else if (opponent==3) {
                    result2.text = "You have saved John connor\nand stopped Skynet"
                    setBackgroundImage(R.drawable.skynetlose)
                }
            }
            game=true
            turn.text=""
        }

        if (button1.text!="" && button1.text==button4.text && button1.text==button7.text)
        {
            if (button1.text=="X") {
                verticalLineRed1.visibility=View.VISIBLE
                if (opponent==1){
                    result.text="You are defeated!"
                    result2.text = "But Stand proud,\nyou are strong"
                    setBackgroundImage(R.drawable.sukunawin)
                }
                else if (opponent==2) {
                    result.text="Defeated you are!"
                    result2.text = "It's over. I have the high ground"
                    setBackgroundImage(R.drawable.vaderwin)
                }
                else if (opponent==3) {
                    result.text="Skynet has won!"
                    result2.text = "You are defeated human as\nyou were destined to"
                    setBackgroundImage(R.drawable.skynetwin)
                }
            }
            else if (button1.text=="O") {
                verticalLineBlue1.visibility=View.VISIBLE
                result.text="Congratulations!"
                if (opponent==1){
                    result2.text = "You have defeated the\n king of curses"
                    setBackgroundImage(R.drawable.sukunalose)
                }
                else if (opponent==2) {
                    result2.text = "Defeated the Dark side you have.May the force be with you"
                    setBackgroundImage(R.drawable.vaderlose)
                }
                else if (opponent==3) {
                    result2.text = "You have saved John connor\nand stopped Skynet"
                    setBackgroundImage(R.drawable.skynetlose)
                }
            }
            game=true
            turn.text=""
        }
        if (button2.text!="" && button2.text==button5.text && button2.text==button8.text)
        {
            if (button2.text=="X") {
                verticalLineRed2.visibility=View.VISIBLE
                if (opponent==1){
                    result.text="You are defeated!"
                    result2.text = "But Stand proud,\nyou are strong"
                    setBackgroundImage(R.drawable.sukunawin)
                }
                else if (opponent==2) {
                    result.text="Defeated you are!"
                    result2.text = "It's over. I have the high ground"
                    setBackgroundImage(R.drawable.vaderwin)
                }
                else if (opponent==3) {
                    result.text="Skynet has won!"
                    result2.text = "You are defeated human as\nyou were destined to"
                    setBackgroundImage(R.drawable.skynetwin)
                }
            }
            else if (button2.text=="O") {
                verticalLineBlue2.visibility=View.VISIBLE
                result.text="Congratulations!"
                if (opponent==1){
                    result2.text = "You have defeated the\n king of curses"
                    setBackgroundImage(R.drawable.sukunalose)
                }
                else if (opponent==2) {
                    result2.text = "Defeated the Dark side you have.May the force be with you"
                    setBackgroundImage(R.drawable.vaderlose)
                }
                else if (opponent==3) {
                    result2.text = "You have saved John connor\nand stopped Skynet"
                    setBackgroundImage(R.drawable.skynetlose)
                }
            }
            game=true
            turn.text=""
        }
        if (button3.text!="" && button3.text==button6.text && button3.text==button9.text)
        {
            if (button3.text=="X") {
                verticalLineRed3.visibility=View.VISIBLE
                if (opponent==1){
                    result.text="You are defeated!"
                    result2.text = "But Stand proud,\nyou are strong"
                    setBackgroundImage(R.drawable.sukunawin)
                }
                else if (opponent==2) {
                    result.text="Defeated you are!"
                    result2.text = "It's over. I have the high ground"
                    setBackgroundImage(R.drawable.vaderwin)
                }
                else if (opponent==3) {
                    result.text="Skynet has won!"
                    result2.text = "You are defeated human as\nyou were destined to"
                    setBackgroundImage(R.drawable.skynetwin)
                }
            }
            else if (button3.text=="O") {
                verticalLineBlue3.visibility=View.VISIBLE
                result.text="Congratulations!"
                if (opponent==1){
                    result2.text = "You have defeated the\n king of curses"
                    setBackgroundImage(R.drawable.sukunalose)
                }
                else if (opponent==2) {
                    result2.text = "Defeated the Dark side you have.May the force be with you"
                    setBackgroundImage(R.drawable.vaderlose)
                }
                else if (opponent==3) {
                    result2.text = "You have saved John connor\nand stopped Skynet"
                    setBackgroundImage(R.drawable.skynetlose)
                }
            }
            game=true
            turn.text=""
        }

        if (button1.text!="" && button1.text==button5.text && button1.text==button9.text)
        {
            if (button1.text=="X") {
                rightdiagonalred.visibility=View.VISIBLE
                if (opponent==1){
                    result.text="You are defeated!"
                    result2.text = "But Stand proud,\nyou are strong"
                    setBackgroundImage(R.drawable.sukunawin)
                }
                else if (opponent==2) {
                    result.text="Defeated you are!"
                    result2.text = "It's over. I have the high ground"
                    setBackgroundImage(R.drawable.vaderwin)
                }
                else if (opponent==3) {
                    result.text="Skynet has won!"
                    result2.text = "You are defeated human as\nyou were destined to"
                    setBackgroundImage(R.drawable.skynetwin)
                }
            }
            else if (button1.text=="O") {
                rightdiagonalblue.visibility=View.VISIBLE
                result.text="Congratulations!"
                if (opponent==1){
                    result2.text = "You have defeated the\n king of curses"
                    setBackgroundImage(R.drawable.sukunalose)
                }
                else if (opponent==2) {
                    result2.text = "Defeated the Dark side you have.May the force be with you"
                    setBackgroundImage(R.drawable.vaderlose)
                }
                else if (opponent==3) {
                    result2.text = "You have saved John connor\nand stopped Skynet"
                    setBackgroundImage(R.drawable.skynetlose)
                }
            }
            game=true
            turn.text=""
        }
        if (button3.text!="" && button3.text==button5.text && button3.text==button7.text)
        {
            if (button3.text=="X") {
                leftdiagonalred.visibility=View.VISIBLE
                if (opponent==1){
                    result.text="You are defeated!"
                    result2.text = "But Stand proud,\nyou are strong"
                    setBackgroundImage(R.drawable.sukunawin)
                }
                else if (opponent==2) {
                    result.text="Defeated you are!"
                    result2.text = "It's over. I have the high ground"
                    setBackgroundImage(R.drawable.vaderwin)
                }
                else if (opponent==3) {
                    result.text="Skynet has won!"
                    result2.text = "You are defeated human as\nyou were destined to"
                    setBackgroundImage(R.drawable.skynetwin)
                }
            }
            else if (button3.text=="O") {
                leftdiagonalblue.visibility=View.VISIBLE
                result.text="Congratulations!"
                if (opponent==1){
                    result2.text = "You have defeated the\n king of curses"
                    setBackgroundImage(R.drawable.sukunalose)
                }
                else if (opponent==2) {
                    result2.text = "Defeated the Dark side you have.May the force be with you"
                    setBackgroundImage(R.drawable.vaderlose)
                }
                else if (opponent==3) {
                    result2.text = "You have saved John connor\nand stopped Skynet"
                    setBackgroundImage(R.drawable.skynetlose)
                }
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
    private fun stopuser(){
        horizontalLineBlue1.visibility=View.GONE
        horizontalLineBlue2.visibility=View.GONE
        horizontalLineBlue3.visibility=View.GONE
        verticalLineBlue1.visibility=View.GONE
        verticalLineBlue2.visibility=View.GONE
        verticalLineBlue3.visibility=View.GONE
        leftdiagonalblue.visibility=View.GONE
        rightdiagonalblue.visibility=View.GONE
        result.text=""
        result2.text=""
        game=false
        if (opponent==1)
            setBackgroundImage(R.drawable.sukuna2)
        else if (opponent==2)
            setBackgroundImage(R.drawable.vader2)
        else if (opponent==3)
            setBackgroundImage(R.drawable.skynet2)
    }
    private fun checkuserwin(): Boolean {
        var userWin=false
        if (difficulty>2) {
            if (!boolArray[0] && !game && !userWin) {
                button1.text = "O"
                checkwin()
                if (!game) {
                    button1.text = ""
                } else {
                    stopuser()
                    button1.text = "X"
                    button1.setTextColor(ContextCompat.getColor(this,R.color.red))
                    boolArray[0] = true
                    userWin = true
                }
            }
            if (!boolArray[1] && !game && !userWin) {
                button2.text = "O"
                checkwin()
                if (!game) {
                    button2.text = ""
                } else {
                    stopuser()
                    button2.text = "X"
                    button2.setTextColor(ContextCompat.getColor(this,R.color.red))
                    boolArray[1] = true
                    userWin = true
                }
            }
            if (!boolArray[2] && !game && !userWin) {
                button3.text = "O"
                checkwin()
                if (!game) {
                    button3.text = ""
                } else {
                    stopuser()
                    button3.text = "X"
                    button3.setTextColor(ContextCompat.getColor(this,R.color.red))
                    boolArray[2] = true
                    userWin = true
                }
            }
            if (!boolArray[3] && !game && !userWin) {
                button4.text = "O"
                checkwin()
                if (!game) {
                    button4.text = ""
                } else {
                    stopuser()
                    button4.text = "X"
                    button4.setTextColor(ContextCompat.getColor(this,R.color.red))
                    boolArray[3] = true
                    userWin = true
                }
            }
            if (!boolArray[4] && !game && !userWin) {
                button5.text = "O"
                checkwin()
                if (!game) {
                    button5.text = ""
                } else {
                    stopuser()
                    button5.text = "X"
                    button5.setTextColor(ContextCompat.getColor(this,R.color.red))
                    boolArray[4] = true
                    userWin = true
                }
            }
            if (!boolArray[5] && !game && !userWin) {
                button6.text = "O"
                checkwin()
                if (!game) {
                    button6.text = ""
                } else {
                    stopuser()
                    button6.text = "X"
                    button6.setTextColor(ContextCompat.getColor(this,R.color.red))
                    boolArray[5] = true
                    userWin = true
                }
            }
            if (!boolArray[6] && !game && !userWin) {
                button7.text = "O"
                checkwin()
                if (!game) {
                    button7.text = ""
                } else {
                    stopuser()
                    button7.text = "X"
                    button7.setTextColor(ContextCompat.getColor(this,R.color.red))
                    boolArray[6] = true
                    userWin = true
                }
            }
            if (!boolArray[7] && !game && !userWin) {
                button8.text = "O"
                checkwin()
                if (!game) {
                    button8.text = ""
                } else {
                    stopuser()
                    button8.text = "X"
                    button8.setTextColor(ContextCompat.getColor(this,R.color.red))
                    boolArray[7] = true
                    userWin = true
                }
            }
            if (!boolArray[8] && !game && !userWin) {
                button9.text = "O"
                checkwin()
                if (!game) {
                    button9.text = ""
                } else {
                    stopuser()
                    button9.text = "X"
                    button9.setTextColor(ContextCompat.getColor(this,R.color.red))
                    boolArray[8] = true
                    userWin = true
                }
            }
        }
        return userWin
    }
    private fun AIturn(){
        if (difficulty>1) {
            if (!boolArray[0] && !game) {
                button1.text = "X"
                button1.setTextColor(ContextCompat.getColor(this,R.color.red))
                checkwin()
                if (!game) {
                    button1.text = ""
                } else {
                    boolArray[0] = true
                }
            }
            if (!boolArray[1] && !game) {
                button2.text = "X"
                button2.setTextColor(ContextCompat.getColor(this,R.color.red))
                checkwin()
                if (!game) {
                    button2.text = ""
                } else {
                    boolArray[1] = true
                }
            }
            if (!boolArray[2] && !game) {
                button3.text = "X"
                button3.setTextColor(ContextCompat.getColor(this,R.color.red))
                checkwin()
                if (!game) {
                    button3.text = ""
                } else {
                    boolArray[2] = true
                }
            }
            if (!boolArray[3] && !game) {
                button4.text = "X"
                button4.setTextColor(ContextCompat.getColor(this,R.color.red))
                checkwin()
                if (!game) {
                    button4.text = ""
                } else {
                    boolArray[3] = true
                }
            }
            if (!boolArray[4] && !game) {
                button5.text = "X"
                button5.setTextColor(ContextCompat.getColor(this,R.color.red))
                checkwin()
                if (!game) {
                    button5.text = ""
                } else {
                    boolArray[4] = true
                }
            }
            if (!boolArray[5] && !game) {
                button6.text = "X"
                button6.setTextColor(ContextCompat.getColor(this,R.color.red))
                checkwin()
                if (!game) {
                    button6.text = ""
                } else {
                    boolArray[5] = true
                }
            }
            if (!boolArray[6] && !game) {
                button7.text = "X"
                button7.setTextColor(ContextCompat.getColor(this,R.color.red))
                checkwin()
                if (!game) {
                    button7.text = ""
                } else {
                    boolArray[6] = true
                }
            }
            if (!boolArray[7] && !game) {
                button8.text = "X"
                button8.setTextColor(ContextCompat.getColor(this,R.color.red))
                checkwin()
                if (!game) {
                    button8.text = ""
                } else {
                    boolArray[7] = true
                }
            }
            if (!boolArray[8] && !game) {
                button9.text = "X"
                button9.setTextColor(ContextCompat.getColor(this,R.color.red))
                checkwin()
                if (!game) {
                    button9.text = ""
                } else {
                    boolArray[8] = true
                }
            }
        }
        if (!game && !checkuserwin()) {
            var moveMade = false
            while (!moveMade) {
                val randomIndex = Random.nextInt(0, 9)
                if (!boolArray[randomIndex]) {
                    when (randomIndex) {
                        0 -> {
                            button1.text = "X"
                            button1.setTextColor(ContextCompat.getColor(this,R.color.red))
                            boolArray[0] = true
                        }
                        1 -> {
                            button2.text = "X"
                            button2.setTextColor(ContextCompat.getColor(this,R.color.red))
                            boolArray[1] = true
                        }
                        2 -> {
                            button3.text = "X"
                            button3.setTextColor(ContextCompat.getColor(this,R.color.red))
                            boolArray[2] = true
                        }
                        3 -> {
                            button4.text = "X"
                            button4.setTextColor(ContextCompat.getColor(this,R.color.red))
                            boolArray[3] = true
                        }
                        4 -> {
                            button5.text = "X"
                            button5.setTextColor(ContextCompat.getColor(this,R.color.red))
                            boolArray[4] = true
                        }
                        5 -> {
                            button6.text = "X"
                            button6.setTextColor(ContextCompat.getColor(this,R.color.red))
                            boolArray[5] = true
                        }
                        6 -> {
                            button7.text = "X"
                            button7.setTextColor(ContextCompat.getColor(this,R.color.red))
                            boolArray[6] = true
                        }
                        7 -> {
                            button8.text = "X"
                            button8.setTextColor(ContextCompat.getColor(this,R.color.red))
                            boolArray[7] = true
                        }
                        8 -> {
                            button9.text = "X"
                            button9.setTextColor(ContextCompat.getColor(this,R.color.red))
                            boolArray[8] = true
                        }
                    }
                    turn.text = "Make your move"
                    turn.setTextColor(ContextCompat.getColor(this, R.color.white))
                    moveMade = true
                }
            }
        }
        checkwin()
    }
    private fun setListeners(){
        button1.setOnClickListener{
            if (!boolArray[0] && !game) {
                button1.text = "O"
                button1.setTextColor(ContextCompat.getColor(this,R.color.blue))
                turn.text="Player 1 turn"
                turn.setTextColor(ContextCompat.getColor(this, R.color.white))
                boolArray[0]=true
                checkwin()
                if (!game)
                    AIturn()
            }
        }
        button2.setOnClickListener{
            if (!boolArray[1] && !game) {
                button2.text = "O"
                button2.setTextColor(ContextCompat.getColor(this,R.color.blue))
                turn.text="Player 1 turn"
                turn.setTextColor(ContextCompat.getColor(this, R.color.white))
                boolArray[1]=true
                checkwin()
                if (!game)
                    AIturn()
            }
        }
        button3.setOnClickListener{
            if (!boolArray[2] && !game) {
                button3.text = "O"
                button3.setTextColor(ContextCompat.getColor(this,R.color.blue))
                turn.text="Player 1 turn"
                turn.setTextColor(ContextCompat.getColor(this, R.color.white))
                boolArray[2] = true
                checkwin()
                if (!game)
                    AIturn()
            }
        }

        button4.setOnClickListener{
            if (!boolArray[3] && !game) {
                button4.text = "O"
                button4.setTextColor(ContextCompat.getColor(this,R.color.blue))
                turn.text="Player 1 turn"
                turn.setTextColor(ContextCompat.getColor(this, R.color.white))
                boolArray[3] = true
                checkwin()
                if (!game)
                    AIturn()
            }
        }
        button5.setOnClickListener{
            if (!boolArray[4] && !game) {
                button5.text = "O"
                button5.setTextColor(ContextCompat.getColor(this,R.color.blue))
                turn.text="Player 1 turn"
                turn.setTextColor(ContextCompat.getColor(this, R.color.white))
                boolArray[4] = true
                checkwin()
                if (!game)
                    AIturn()
            }
        }
        button6.setOnClickListener{
            if (!boolArray[5] && !game) {
                button6.text = "O"
                button6.setTextColor(ContextCompat.getColor(this,R.color.blue))
                turn.text="Player 1 turn"
                turn.setTextColor(ContextCompat.getColor(this, R.color.white))
                boolArray[5] = true
                checkwin()
                if (!game)
                    AIturn()
            }
        }

        button7.setOnClickListener{
            if (!boolArray[6] && !game) {
                button7.text = "O"
                button7.setTextColor(ContextCompat.getColor(this,R.color.blue))
                turn.text="Player 1 turn"
                turn.setTextColor(ContextCompat.getColor(this, R.color.white))
                boolArray[6] = true
                checkwin()
                if (!game)
                    AIturn()
            }
        }
        button8.setOnClickListener{
            if (!boolArray[7] && !game) {
                button8.text = "O"
                button8.setTextColor(ContextCompat.getColor(this,R.color.blue))
                turn.text="Player 1 turn"
                turn.setTextColor(ContextCompat.getColor(this, R.color.white))
                boolArray[7] = true
                checkwin()
                if (!game)
                    AIturn()
            }
        }
        button9.setOnClickListener{
            if (!boolArray[8] && !game) {
                button9.text = "O"
                button9.setTextColor(ContextCompat.getColor(this,R.color.blue))
                turn.text="Player 1 turn"
                turn.setTextColor(ContextCompat.getColor(this, R.color.white))
                boolArray[8] = true
                checkwin()
                if (!game)
                    AIturn()
            }
        }
    }
}