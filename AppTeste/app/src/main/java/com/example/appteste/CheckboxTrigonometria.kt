package com.example.appteste

import android.app.AlertDialog
import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CheckboxTrigonometria : AppCompatActivity() {
    private val estados: List<String> = listOf  (
        "Salvador",
        "João Pessoa",
        "Maceió",
        "Goiânia",
        "Belo Horizonte",
        "Recife",
        "Porto Velho",
        "Boa Vista",
        "Florianópolis",
        "São Paulo",
        "Aracaju",
        "Rio Branco",
        "Macapá",
        "Manaus",
        "Fortaleza",
        "Vitória",
        "São Luís",
        "Cuiabá",
        "Campo Grande",
        "Belém",
        "Curitiba",
        "Teresina",
        "Rio de Janeiro",
        "Natal",
        "Porto Alegre",
        "Palmas",
        "Brasília"
    )

    private val imagens = intArrayOf(
        R.drawable.img,
        R.drawable.img_1,
        R.drawable.img_2,
        R.drawable.img_3,
        R.drawable.img_4,
        R.drawable.img_5,
        R.drawable.img_6,
        R.drawable.img_7,
        R.drawable.img_8,
        R.drawable.img_9,
        R.drawable.img_10,
        R.drawable.img_11,
        R.drawable.img_12,
        R.drawable.img_13,
        R.drawable.img_14,
        R.drawable.img_15,
        R.drawable.img_16,
        R.drawable.img_17,
        R.drawable.img_18,
        R.drawable.img_19,
        R.drawable.img_20,
        R.drawable.img_21,
        R.drawable.img_22,
        R.drawable.img_23,
        R.drawable.img_24,
        R.drawable.img_25,
        R.drawable.img_26
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkbox_trigonometria)

        val lista = findViewById<ListView>(R.id.lista)
        val capitais = resources.getStringArray((R.array.capitais))

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, capitais)
        lista.adapter = adapter

        lista.setOnItemClickListener { _, _, position, _ ->
            mostrarDialogCapitais(capitais[position], imagens[position])
        }
    }

    private fun mostrarDialogCapitais(nome: String, imgRes: Int){
        val view = LayoutInflater.from(this).inflate(R.layout.dialog_item, null)

        val  img = view.findViewById<ImageView>(R.id.imgEstado)
        val txtEstado = view.findViewById<TextView>(R.id.txtEstado)

        img.setImageResource(imgRes)
        txtEstado.text = nome

        val dialog = AlertDialog.Builder(this).setView(view)
            .setNegativeButton((R.string.fechar), null)
            .create()

        dialog.show()
    }
}