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

class Atividade4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_atividade4)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val campo1 = findViewById<EditText>(R.id.massa)
        val campo2 = findViewById<EditText>(R.id.velo)

        val resultado = findViewById<TextView>(R.id.energ)

        val botaoEnergia = findViewById<Button>(R.id.calc)

        //Botao para calcular

        botaoEnergia.setOnClickListener {
            try {
                val v1 = campo1.text.toString().toDouble()
                val v2 = campo2.text.toString().toDouble()

                val total = (v1 * (Math.pow(v2, 2.0)))/2

                resultado.text = total.toString()
            } catch (e: Exception){
                Toast.makeText(this, "Digite um valor válido, por favor!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}