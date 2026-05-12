package com.example.appteste

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LanchoneteSpinner : AppCompatActivity() {

    private val imagens = intArrayOf(
        R.drawable.img_35,
        R.drawable.img_36,
        R.drawable.img_34
    )

    private val precos = doubleArrayOf(
        25.90,
        35.50,
        18.00
    )

    private val nomes = listOf("Hambúrguer", "Pizza", "Salada")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lanchonete_spinner)

        val spinner = findViewById<Spinner>(R.id.spinnerLanche)
        val edtQtd = findViewById<EditText>(R.id.edtQtdLanche)
        val btnCalc = findViewById<Button>(R.id.btnCalcularLanche)
        val txtRes = findViewById<TextView>(R.id.txtResultadoLanche)

        spinner.adapter = SpinnerAdapter(this, nomes, imagens)

        btnCalc.setOnClickListener {
            val qtd = edtQtd.text.toString().toDoubleOrNull()

            if (qtd == null || qtd <= 0) {
                txtRes.text = "Informe uma quantidade válida!"
                return@setOnClickListener
            }

            val pos = spinner.selectedItemPosition
            val subtotal = precos[pos] * qtd

            val total = if (qtd >= 3) subtotal * (1 - 0.05) else subtotal

            val resultado = StringBuilder()
            resultado.appendLine("Subtotal: R$ %.2f".format(subtotal))
            if (qtd >= 3)
                resultado.appendLine("Desconto 5%: - R$ %.2f".format(subtotal * 0.05))
            resultado.append("Total: R$ %.2f".format(total))

            txtRes.text = resultado.toString()
        }
    }
}