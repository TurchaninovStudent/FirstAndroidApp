package com.example.firstandroidapplication.firstandroidapp

import kotlin.random.Random
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.firstandroidapplication.firstandroidapp.databinding.ActivityMainBinding

/**
 * Главная View приложения
 */
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val button = binding.roll

        button.setOnClickListener {
            button.rotationX = 0.0f
            button.animate().rotationX(360.0f).setDuration(400).start()
            setRandom()
        }
    }

    private fun setRandom() {
        val textToInputIn = binding.tutorialText
        textToInputIn.text = Random.nextInt(1, 7).toString()
        textToInputIn.textSize = 48.0f
    }
}