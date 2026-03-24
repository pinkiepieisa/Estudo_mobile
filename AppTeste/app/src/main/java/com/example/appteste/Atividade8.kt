package com.example.appteste

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Atividade8 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_atividade8)

        val campo1 = findViewById<EditText>(R.id.editC1)
        val campo2 = findViewById<EditText>(R.id.editC2)
        val campo3 = findViewById<EditText>(R.id.editV1)
        val campo4 = findViewById<EditText>(R.id.editV2)

        val resultado = findViewById<TextView>(R.id.result8)

        val botao = findViewById<Button>(R.id.button8)

        //Botao para calcular

        botao.setOnClickListener {
            try {
                val c1 = campo1.text.toString().toDouble()
                val c2 = campo2.text.toString().toDouble()
                val v1 = campo3.text.toString().toDouble()
                val v2 = campo4.text.toString().toDouble()

                val c = c1 * v1
                val v = c2 * v2
                val total = c.toString() + "=" + v.toString()

                resultado.text = total

            } catch (e: Exception){
                Toast.makeText(this, "Digite um valor válido, por favor!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}