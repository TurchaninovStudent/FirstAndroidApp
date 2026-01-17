package com.example.firstandroidapplication.firstandroidapp

import kotlin.random.Random
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val textToInputIn: TextView = findViewById(R.id.tutorialText)
        val button: Button = findViewById(R.id.roll)

        button.setOnClickListener {
            button.rotationX = 0.0f
            button.animate().rotationX(360.0f).setDuration(400).start()
            setRandom(textToInputIn)
        }
    }

    private fun setRandom(textToInputIn : TextView) {
        textToInputIn.text = Random.nextInt(1, 6).toString()
        textToInputIn.textSize = 48.0f
    }
}