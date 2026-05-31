package com.example.projetoconfeitaria

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.*
import kotlinx.coroutines.*

class ListaProd : AppCompatActivity() {

    private val ui = CoroutineScope(Dispatchers.Main)
    private var itens = mutableListOf<String>()
    private var produtos = mutableListOf<Confeitaria>()
    private lateinit var adaptador: ArrayAdapter<String>
    private var selecionado: Confeitaria? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_prod)

        val btnAtualizar: Button = findViewById(R.id.btnAtualizarProd)
        val btnExcluir: Button = findViewById(R.id.btnExcluirProd)
        val lista: ListView = findViewById(R.id.listaProd)

        adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1, itens)
        lista.adapter = adaptador

        lista.setOnItemClickListener { _, _, position, _ ->
            selecionado = produtos[position]
            toast("Selecionado: ${selecionado!!.nome}")
        }

        btnAtualizar.setOnClickListener {
            if (selecionado == null) {
                toast("Selecione um produto primeiro")
                return@setOnClickListener
            }
            val intent = Intent(this, AtualizarProd::class.java)
            intent.putExtra("id", selecionado!!.id_produto)
            intent.putExtra("nome", selecionado!!.nome)
            intent.putExtra("valor", selecionado!!.valor)
            intent.putExtra("peso", selecionado!!.peso)
            intent.putExtra("descricao", selecionado!!.descricao)
            startActivity(intent)
        }

        btnExcluir.setOnClickListener {
            if (selecionado == null) {
                toast("Selecione um produto primeiro")
                return@setOnClickListener
            }
            ui.launch {
                try {
                    withContext(Dispatchers.IO) { RetrofitClient.api.excluirProduto(selecionado!!.id_produto!!) }
                    toast("Excluído com sucesso!")
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
                val dados = withContext(Dispatchers.IO) { RetrofitClient.api.listarProdutos() }
                produtos.clear()
                produtos.addAll(dados)
                itens.clear()
                dados.forEach { p ->
                    itens.add("#${p.id_produto} - ${p.nome} | R$ ${p.valor} | ${p.peso}kg")
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