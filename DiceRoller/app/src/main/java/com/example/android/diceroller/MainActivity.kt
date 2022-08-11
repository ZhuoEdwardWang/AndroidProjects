package com.example.android.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import android.widget.Button
import android.widget.ImageView
import java.util.*


class MainActivity : AppCompatActivity() {

    lateinit var diceImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val contentView: View = findViewById(android.R.id.content)
//        contentView.viewTreeObserver.addOnPreDrawListener(object :
//            ViewTreeObserver.OnPreDrawListener {
//            override fun onPreDraw(): Boolean {
//                return false
//            }
//        })
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener {
            rollDice()
//            Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()
        }

        diceImage = findViewById(R.id.dice_image)
    }

    private fun rollDice() {
        val drawableResource = when (Random().nextInt(6) + 1) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
//        val diceImage: ImageView = findViewById(R.id.dice_image)
        diceImage.setImageResource(drawableResource)
    }
}