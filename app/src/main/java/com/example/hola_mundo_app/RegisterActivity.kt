package com.example.hola_mundo_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val buttonRegister = findViewById<Button>(R.id.buttonRegister)
        val textViewLogin = findViewById<TextView>(R.id.textViewLogin)

        textViewLogin.setOnClickListener {
            // muestra un alertDialog o algo así
            Toast.makeText(this, "Redirigido al login!!", Toast.LENGTH_LONG).show()

            // dirigir a otra vista
            val intentLogin = Intent(this, LoginActivity::class.java)
            startActivity(intentLogin)
        }

        buttonRegister.setOnClickListener {
            // registro de usuario

        }
    }
}