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

class Atividade7 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_atividade7)

        val campo1 = findViewById<EditText>(R.id.editTV)
        val campo2 = findViewById<EditText>(R.id.editTA)
        val campo3 = findViewById<EditText>(R.id.editTS)

        val resultado = findViewById<TextView>(R.id.result7)

        val botao = findViewById<Button>(R.id.button7)

        //Botao para calcular

        botao.setOnClickListener {
            try {
                val v1 = campo1.text.toString().toDouble()
                val v2 = campo2.text.toString().toDouble()
                val v3 = campo3.text.toString().toDouble()

                val total = (Math.pow(v1, 2.0)) + 2 * v2 * v3
                val total2 = Math.pow(total, 2.0)

                resultado.text = total2.toString()

            } catch (e: Exception){
                Toast.makeText(this, "Digite um valor válido, por favor!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}