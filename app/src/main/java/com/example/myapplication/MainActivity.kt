package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val dice = Dice()// private because of class-limited using
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        displayDiceOnStartup()
        val button : Button = findViewById(R.id.button)//Take attention on variable declaring
        button.setOnClickListener {
            rollDice()
        }
    }
    private fun rollDice(){
        val x = dice.roll()
        val text : TextView = findViewById(R.id.textView)//Take attention on variable declaring
        val text2 : TextView = findViewById(R.id.textView2)//Take attention on variable declaring
        val image : ImageView = findViewById(R.id.imageView)
        when (x) {
            1 -> text2.text = "Not the lucky number"
            2 -> text2.text = "Not the lucky number"
            3 -> text2.text = "Not the lucky number"
            4 -> text2.text = "Not the lucky number"
            5 -> text2.text = "Not the lucky number"
            6 -> text2.text = "U got the lucky number"
        }
        val drawableResource = when (x) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        image.setImageResource(drawableResource)
        text.text = "You got\n${x}"
    }
    private  fun displayDiceOnStartup(){
        val image : ImageView = findViewById(R.id.imageView)
        image.setImageResource(R.drawable.dice_5)
    }
}
class Dice{
    fun roll() : Int{
        //Return is different from Java as well
        return (1..6).random()//Amazing way to shorten my code to one line
    }
}