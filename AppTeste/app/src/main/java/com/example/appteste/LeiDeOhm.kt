package com.example.appteste

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LeiDeOhm : AppCompatActivity() {

    private var opcaoSelecionada = "tensao"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lei_de_ohm)

        val radioGroup = findViewById<RadioGroup>(R.id.rgOhm)
        val rbTensao = findViewById<RadioButton>(R.id.rbTensao)
        val edtTensao = findViewById<EditText>(R.id.edtTensao)
        val edtCorrente = findViewById<EditText>(R.id.edtCorrente)
        val edtResistencia = findViewById<EditText>(R.id.edtResistencia)
        val btnCalcular = findViewById<Button>(R.id.btnCalcularOhm)
        val txtResultado = findViewById<TextView>(R.id.txtResultadoOhm)

        rbTensao.isChecked = true
        atualizarCampos(edtTensao, edtCorrente, edtResistencia, opcaoSelecionada)

        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            opcaoSelecionada = when (checkedId) {
                R.id.rbTensao -> "tensao"
                R.id.rbCorrente -> "corrente"
                R.id.rbResistencia -> "resistencia"
                else -> "tensao"
            }
            atualizarCampos(edtTensao, edtCorrente, edtResistencia, opcaoSelecionada)
            txtResultado.text = ""
        }

        btnCalcular.setOnClickListener {
            calcular(opcaoSelecionada, edtTensao, edtCorrente, edtResistencia, txtResultado)
        }
    }

    private fun atualizarCampos(
        edtTensao: EditText,
        edtCorrente: EditText,
        edtResistencia: EditText,
        opcao: String
    ) {
        edtTensao.text.clear()
        edtCorrente.text.clear()
        edtResistencia.text.clear()

        when (opcao) {
            "tensao" -> {
                edtTensao.visibility = View.GONE
                edtCorrente.visibility = View.VISIBLE
                edtResistencia.visibility = View.VISIBLE
            }
            "corrente" -> {
                edtTensao.visibility = View.VISIBLE
                edtCorrente.visibility = View.GONE
                edtResistencia.visibility = View.VISIBLE
            }
            "resistencia" -> {
                edtTensao.visibility = View.VISIBLE
                edtCorrente.visibility = View.VISIBLE
                edtResistencia.visibility = View.GONE
            }
        }
    }

    private fun calcular(
        opcao: String,
        edtTensao: EditText,
        edtCorrente: EditText,
        edtResistencia: EditText,
        txtResultado: TextView
    ) {
        val v = edtTensao.text.toString().toDoubleOrNull()
        val i = edtCorrente.text.toString().toDoubleOrNull()
        val r = edtResistencia.text.toString().toDoubleOrNull()

        when (opcao) {
            "tensao" -> {
                if (i == null || r == null) {
                    Toast.makeText(this, R.string.erro_campos, Toast.LENGTH_SHORT).show()
                    return
                }
                val resultado = r * i
                txtResultado.text = getString(R.string.resultado_tensao).format(resultado)
            }
            "corrente" -> {
                if (v == null || r == null || r == 0.0) {
                    Toast.makeText(this, R.string.erro_campos, Toast.LENGTH_SHORT).show()
                    return
                }
                val resultado = v / r
                txtResultado.text = getString(R.string.resultado_corrente).format(resultado)
            }
            "resistencia" -> {
                if (v == null || i == null || i == 0.0) {
                    Toast.makeText(this, R.string.erro_campos, Toast.LENGTH_SHORT).show()
                    return
                }
                val resultado = v / i
                txtResultado.text = getString(R.string.resultado_resistencia).format(resultado)
            }
        }
    }
}