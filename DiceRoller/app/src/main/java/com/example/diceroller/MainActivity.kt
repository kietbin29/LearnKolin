package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button : Button = findViewById(R.id.button);
        button.setOnClickListener {
            rollDice()
        }
        rollDice()
        button.setOnClickListener {
            val toast = Toast.makeText(this, "Dice Roller!", Toast.LENGTH_SHORT)
            toast.show();
        }
        button.setOnClickListener {
            val resultTextView : ImageView = findViewById(R.id.imageView);
//            resultTextView.text = "6";
        }
    }

    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val diceImage: ImageView = findViewById(R.id.imageView)
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> {R.drawable.dice_6}
        }

        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll.toString()
    }
    class Dice(val numSides: Int){
        fun roll(): Int{
            return (1..numSides).random()
        }
    }
}


