package com.example.android.dicerollerlab4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.android.dicerollerlab4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val rollButton = binding.rollButton
        rollButton.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {
        val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
        toast.show()
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val resultImageView: ImageView = binding.imageView
        val drawableResource = when (diceRoll){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        resultImageView.setImageResource(drawableResource)
        resultImageView.contentDescription = diceRoll.toString()

    }
}

