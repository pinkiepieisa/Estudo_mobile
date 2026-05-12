package com.example.appteste

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PapelariaSpinner : AppCompatActivity() {

    private val imagens = intArrayOf(
        R.drawable.img_35,
        R.drawable.img_36,
        R.drawable.img_34
    )

    private val precos = doubleArrayOf(
        18.90,
        4.50,
        8.75
    )

    private val nomes = listOf("Caderno", "Caneta", "Marcador")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_papelaria_spinner)

        val spinner = findViewById<Spinner>(R.id.spinnerPapelaria)
        val edtQtd = findViewById<EditText>(R.id.edtQtdPapelaria)
        val btnCalc = findViewById<Button>(R.id.btnCalcularPapelaria)
        val txtRes = findViewById<TextView>(R.id.txtResultadoPapelaria)

        spinner.adapter = SpinnerAdapter(this, nomes, imagens)

        btnCalc.setOnClickListener {
            val qtd = edtQtd.text.toString().toDoubleOrNull()

            if (qtd == null || qtd <= 0) {
                txtRes.text = "Informe uma quantidade válida!"
                return@setOnClickListener
            }

            val pos = spinner.selectedItemPosition
            val subtotal = precos[pos] * qtd

            // Taxa de 10%
            val total = subtotal * 1.10

            txtRes.text = "Subtotal: R$ %.2f\nTaxa (10%%): R$ %.2f\nTotal: R$ %.2f"
                .format(subtotal, subtotal * 0.10, total)
        }
    }
}