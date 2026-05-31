package com.example.projetoconfeitaria

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.*
import kotlinx.coroutines.*

class ListaFunc : AppCompatActivity() {

    private val ui = CoroutineScope(Dispatchers.Main)
    private var itens = mutableListOf<String>()
    private var funcionarios = mutableListOf<Funcionario>()
    private lateinit var adaptador: ArrayAdapter<String>
    private var selecionado: Funcionario? = null  // guarda quem foi clicado

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_func)

        val btnAtualizar: Button = findViewById(R.id.btnAtualizar)
        val btnExcluir: Button = findViewById(R.id.btnExcluir)
        val lista: ListView = findViewById(R.id.lista)

        adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1, itens)
        lista.adapter = adaptador

        // Clica no item da lista pra selecionar
        lista.setOnItemClickListener { _, _, position, _ ->
            selecionado = funcionarios[position]
            toast("Selecionado: ${selecionado!!.nome}")
        }

        btnAtualizar.setOnClickListener {
            if (selecionado == null) {
                toast("Selecione um funcionário primeiro")
                return@setOnClickListener
            }
            val intent = Intent(this, AtualizarFunc::class.java)
            intent.putExtra("id", selecionado!!.id_funcionario)
            intent.putExtra("nome", selecionado!!.nome)
            intent.putExtra("email", selecionado!!.email)
            intent.putExtra("senha", selecionado!!.senha)
            intent.putExtra("cargo", selecionado!!.cargo)
            startActivity(intent)
        }

        btnExcluir.setOnClickListener {
            if (selecionado == null) {
                toast("Selecione um funcionário primeiro")
                return@setOnClickListener
            }
            ui.launch {
                try {
                    withContext(Dispatchers.IO) { RetrofitClient.api.excluir(selecionado!!.id_funcionario!!) }
                    toast("Excluído com sucesso")
                    selecionado = null
                    listar()
                } catch (e: Exception) {
                    toast("Erro ao excluir: ${e.message}")
                }
            }
        }

        listar()
    }

    private fun listar() {
        ui.launch {
            try {
                val dados = withContext(Dispatchers.IO) { RetrofitClient.api.listar() }
                funcionarios.clear()
                funcionarios.addAll(dados)
                itens.clear()
                dados.forEach { f ->
                    itens.add("#${f.id_funcionario} - ${f.nome} | ${f.email} | ${f.cargo}")
                }
                adaptador.notifyDataSetChanged()
            } catch (e: Exception) {
                toast("Erro ao listar: ${e.message}")
            }
        }
    }

    private fun toast(msg: String) =
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

}