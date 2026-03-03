package com.example.appteste

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
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

        val campo1 = findViewById<EditText>(R.id.pt1)
        val campo2 = findViewById<EditText>(R.id.pt2)

        val resultado = findViewById<TextView>(R.id.tv2)
        val botao = findViewById<Button>(R.id.bt1)

        //Botão de resultado
        botao.setOnClickListener {
            try {
                val dist = campo1.text.toString().toDouble()
                val tmp = campo2.text.toString().toDouble()

                val total = dist/tmp

                resultado.text = total.toString()
            } catch (e: Exception) {
                Toast.makeText(this, "Digite um valor válido, por favor!", Toast.LENGTH_SHORT).show()
            }
        }

    }
}