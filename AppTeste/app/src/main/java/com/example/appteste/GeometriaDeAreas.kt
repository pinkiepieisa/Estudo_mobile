package com.example.appteste

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class GeometriaDeAreas : AppCompatActivity() {
private var nomeSelecionado = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_geometria_de_areas)

        val titulo = findViewById<TextView>(R.id.txtTitulo3)
        val radioGroup = findViewById<RadioGroup>(R.id.rgGeometria)
        val rbCirculo = findViewById<RadioButton>(R.id.rbCirculo)
        val rbRetangulo = findViewById<RadioButton>(R.id.rbRetangulo)
        val rbTriangulo = findViewById<RadioButton>(R.id.rbTriangulo)
        val edtRaio = findViewById<EditText>(R.id.edtRaio)
        val edtBase = findViewById<EditText>(R.id.edtBase)
        val edtAltura = findViewById<EditText>(R.id.edtAltura)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val txtItemInfo = findViewById<TextView>(R.id.txtItemInfo)
        val txtTotal = findViewById<TextView>(R.id.txtTotal)

        titulo.text = getString(R.string.app_titulo3)

        fun atualizarCampos(edtRaio: EditText, edtBase: EditText, edtAltura: EditText, nome: String) {
            when (nome) {
                getString(R.string.circulo) -> {
                    edtRaio.visibility = android.view.View.VISIBLE
                    edtBase.visibility = android.view.View.GONE
                    edtAltura.visibility = android.view.View.GONE
                }
                getString(R.string.retangulo) -> {
                    edtRaio.visibility = android.view.View.GONE
                    edtBase.visibility = android.view.View.VISIBLE
                    edtAltura.visibility = android.view.View.VISIBLE
                }
                getString(R.string.triangulo) -> {
                    edtRaio.visibility = android.view.View.GONE
                    edtBase.visibility = android.view.View.VISIBLE
                    edtAltura.visibility = android.view.View.VISIBLE
                }
            }
        }

        fun calcular(nome: String, edtRaio: EditText, edtBase: EditText, edtAltura: EditText, txtItemInfo: TextView, txtTotal: TextView) {
            val area: Double

            when (nome) {
                getString(R.string.circulo) -> {
                    val raio = edtRaio.text.toString().toDoubleOrNull() ?: 0.0
                    area = Math.PI * raio * raio
                    txtItemInfo.text = "Raio: $raio"
                }
                getString(R.string.retangulo) -> {
                    val base = edtBase.text.toString().toDoubleOrNull() ?: 0.0
                    val altura = edtAltura.text.toString().toDoubleOrNull() ?: 0.0
                    area = base * altura
                    txtItemInfo.text = "Base: $base | Altura: $altura"
                }
                getString(R.string.triangulo) -> {
                    val base = edtBase.text.toString().toDoubleOrNull() ?: 0.0
                    val altura = edtAltura.text.toString().toDoubleOrNull() ?: 0.0
                    area = (base * altura) / 2
                    txtItemInfo.text = "Base: $base | Altura: $altura"
                }
                else -> return
            }

            txtTotal.text = "Área do $nome: %.2f".format(area)
        }

        rbCirculo.isChecked = true
        nomeSelecionado = getString(R.string.circulo)
        atualizarCampos(edtRaio, edtBase, edtAltura, nomeSelecionado)

        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            nomeSelecionado = when (checkedId) {
                R.id.rbCirculo -> getString(R.string.circulo)
                R.id.rbRetangulo -> getString(R.string.retangulo)
                R.id.rbTriangulo -> getString(R.string.triangulo)
                else -> ""
            }
            atualizarCampos(edtRaio, edtBase, edtAltura, nomeSelecionado)
        }
        btnCalcular.setOnClickListener {
            calcular(nomeSelecionado, edtRaio, edtBase, edtAltura, txtItemInfo, txtTotal)
        }
    }
}


