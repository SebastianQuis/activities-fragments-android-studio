package com.example.hola_mundo_app

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat



class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_layout)

        // console log
        Log.i("LoginActivity", "Mi metodo: onCreate")

        val buttonLogin = findViewById<Button>(R.id.buttonLogin)
        val textViewRegistrate = findViewById<TextView>(R.id.textViewRegistrate)

        textViewRegistrate.setOnClickListener {
            // muestra un alertDialog o algo así
            Toast.makeText(this, "Redirigido al registro!!", Toast.LENGTH_LONG).show()

            //dirigir a otra actividad o vista
            val intentRegister = Intent(this, RegisterActivity::class.java)
            startActivity(intentRegister)
        }

        buttonLogin.setOnClickListener {
            // iniciar sesion..
        }


        // TRABAJANDO CON FRAGMENTOS
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        // INSTANCIANDO TODOS LOS FRAGMENTOS A UTILIZAR
        val mainFragment = MainFragment()
        val secondFragment = SecondFragment()

        // AÑADIENDO EL FRAGMENTO INCIAL A LA VISTA
        fragmentTransaction.add(R.id.frameLayoutFragment, mainFragment)
        fragmentTransaction.commit()

        val buttonFragment1 = findViewById<Button>(R.id.buttonFragment1)
        val buttonFragment2 = findViewById<Button>(R.id.buttonFragment2)

        // CREAR NUEVAS TRANSACTION PARA CADA FRAGMENT
        buttonFragment1.setOnClickListener {
            val newFragmentTransaction = fragmentManager.beginTransaction()
            newFragmentTransaction.replace(R.id.frameLayoutFragment, mainFragment)
            // GUARDE EN EL STACK EL FRAGMENT ANTERIOR Y REGRESAR CON EL BOTON DE REGRESO
            newFragmentTransaction.addToBackStack(null)
            newFragmentTransaction.commit()
        }

        buttonFragment2.setOnClickListener {
            val newFragmentTransaction = fragmentManager.beginTransaction()
            newFragmentTransaction.replace(R.id.frameLayoutFragment, secondFragment)
            newFragmentTransaction.addToBackStack(null)
            newFragmentTransaction.commit()
        }

    }



    override fun onStart() {
        super.onStart()
        Log.i("LoginActivity", "Mi metodo: onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("LoginActivity", "Mi metodo: onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("LoginActivity", "Mi metodo: onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("LoginActivity", "Mi metodo: onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("LoginActivity", "Mi metodo: onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("LoginActivity", "Mi metodo: onRestart")
    }
}