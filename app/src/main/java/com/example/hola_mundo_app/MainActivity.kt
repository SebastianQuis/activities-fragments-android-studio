package com.example.hola_mundo_app

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    //lateinit var textViewTitle: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        setContentView(R.layout.constraits_layout)

        // val textViewTitle = findViewById<TextView>(R.id.textViewTitle)
        val textViewTitle = findViewById<TextView>(R.id.textViewTitle)
        val textViewDescription = findViewById<TextView>(R.id.textViewSubtitle)

        textViewTitle.text = "mi nuevo titulo"
        textViewTitle.textSize = 40f // f de flotante

        textViewDescription.text = "una pequeña descripción"
        textViewDescription.setBackgroundColor(Color.BLUE)
        textViewDescription.setTextColor(Color.BLACK)
    }
}