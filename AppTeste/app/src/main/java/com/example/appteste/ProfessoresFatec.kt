package com.example.appteste

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfessoresFatec : AppCompatActivity() {
    private val professores: List<String> = listOf(
        "Fernanda Pereira",
        "Eduardo Tadeu",
        "Mario da silva",
        "Leandro Ferro",
        "Silvio Fernando",
        "Junio César",
        "André Benito"
    )

    private val descricoes: List<String> = listOf(
        "Introdução à arquitetura e conceitos de IoT, desenvolvimento com Arduino e simuladores.",
        "Estudo da Experiência do Usuário e do Consumidor, com foco no perfil do usuário e conceitos fundamentais de UX.",
        "Introdução ao desenvolvimento para dispositivos móveis, abordando tipos de dispositivos, sistemas operacionais e arquitetura Android.",
        "Estudo do inglês com foco em bases tecnológicas, vocabulário e Simple Past.",
        "Conceitos de Integração e Entrega Contínuas, histórico, pré-requisitos e configuração de ambiente de produção.",
        "Introdução ao desenvolvimento web, princípios SOLID e boas práticas de desenvolvimento de sistemas.",
        "Introdução à estatística com tabelas de frequência, conjuntos, diagramas de Venn e operações entre conjuntos."
    )

    private  val imagens2 = intArrayOf(
        R.drawable.img_27,
        R.drawable.img_28,
        R.drawable.img_29,
        R.drawable.img_30,
        R.drawable.img_31,
        R.drawable.img_32,
        R.drawable.img_33
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_professores_fatec)

        val lista = findViewById<ListView>(R.id.lista2)
        val disciplinas = resources.getStringArray(R.array.disciplinas)
        val nomes = resources.getStringArray(R.array.nomes)
        val descricoes = resources.getStringArray(R.array.descricoes)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,disciplinas)
        lista.adapter = adapter

        lista.setOnItemClickListener { _, _, position, _ ->
            mostrarDialogMaterias(disciplinas[position], professores[position], descricoes[position], imagens2[position])
        }
    }

    private fun mostrarDialogMaterias(disciplina: String, professor: String, descricao: String, imgRes: Int) {
        val view = LayoutInflater.from(this).inflate(R.layout.dialog_item2, null)

        val img = view.findViewById<ImageView>(R.id.imgProfe)
        val txtProf = view.findViewById<TextView>(R.id.textNome)
        val txtDesc = view.findViewById<TextView>(R.id.txtDescricao)

        img.setImageResource(imgRes)
        txtProf.text = "Professor: $professor"
        txtDesc.text = "Descrição: $descricao"

        val dialog = AlertDialog.Builder(this)
            .setTitle(disciplina)
            .setView(view)
            .setNegativeButton(R.string.fechar2, null)
            .create()

        dialog.show()
    }
}