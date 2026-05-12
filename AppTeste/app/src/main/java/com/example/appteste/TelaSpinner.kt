package com.example.appteste

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TelaSpinner : AppCompatActivity() {

    private val imagensDoces = intArrayOf(
        R.drawable.img_34,
        R.drawable.img_36,
        R.drawable.img_35
    )

    private val precos = doubleArrayOf(
        12.33,
        15.78,
        17.89
    )

    private val nomes = listOf("Bolo de chocolate", "Bolo de cenoura", "Bolo de morango")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_spinner)

        val spinner = findViewById<Spinner>(R.id.spinnerOp)
        val edtQtd = findViewById<EditText>(R.id.edtVQ)
        val btnCalc = findViewById<Button>(R.id.btnCalcular)
        val txtRes = findViewById<TextView>(R.id.txtResultado)

        val adapter = SpinnerAdapter(this, nomes, imagensDoces)
        spinner.adapter = adapter

        btnCalc.setOnClickListener {
            val qtd = edtQtd.text.toString().toDoubleOrNull()

            if (qtd == null || qtd <= 0) {
                txtRes.text = "Informe uma quantidade válida!"
                return@setOnClickListener
            }

            val pos = spinner.selectedItemPosition
            val total = precos[pos] * qtd
            txtRes.text = "Total: R$ %.2f".format(total)
        }
    }
}