package com.example.appteste

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CombustivelSpinner : AppCompatActivity() {

    private val imagens = intArrayOf(
        R.drawable.img_34,
        R.drawable.img_35,
        R.drawable.img_36
    )

    private val precos = doubleArrayOf(
        6.29,
        4.89,
        5.99
    )

    private val nomes = listOf("Gasolina", "Etanol", "Diesel")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_combustivel_spinner)

        val spinner = findViewById<Spinner>(R.id.spinnerCombustivel)
        val edtLitros = findViewById<EditText>(R.id.edtLitros)
        val btnCalc = findViewById<Button>(R.id.btnCalcularCombustivel)
        val txtRes = findViewById<TextView>(R.id.txtResultadoCombustivel)

        spinner.adapter = SpinnerAdapter(this, nomes, imagens)

        btnCalc.setOnClickListener {
            val litros = edtLitros.text.toString().toDoubleOrNull()

            if (litros == null || litros <= 0) {
                txtRes.text = "Informe uma quantidade válida!"
                return@setOnClickListener
            }

            val pos = spinner.selectedItemPosition
            val total = precos[pos] * litros

            txtRes.text = "${nomes[pos]}: R$ %.2f/L × %.2fL = R$ %.2f"
                .format(precos[pos], litros, total)
        }
    }
}