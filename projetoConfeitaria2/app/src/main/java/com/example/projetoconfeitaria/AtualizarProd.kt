package com.example.projetoconfeitaria

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.*
import kotlinx.coroutines.*

class AtualizarProd : AppCompatActivity() {

    private val ui = CoroutineScope(Dispatchers.Main)
    private var idProduto: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_atualizar_prod)

        val edtNome: EditText = findViewById(R.id.editNomeProd2)
        val edtValor: EditText = findViewById(R.id.editValorProd2)
        val edtPeso: EditText = findViewById(R.id.editPesoProd2)
        val edtDescricao: EditText = findViewById(R.id.editDescricaoProd2)
        val btnSalvar: Button = findViewById(R.id.btnSalvarProd2)

        idProduto = intent.getIntExtra("id", -1)
        edtNome.setText(intent.getStringExtra("nome"))
        edtValor.setText(intent.getFloatExtra("valor", 0f).toString())
        edtPeso.setText(intent.getFloatExtra("peso", 0f).toString())
        edtDescricao.setText(intent.getStringExtra("descricao"))

        btnSalvar.setOnClickListener {
            if (idProduto == null || idProduto == -1) {
                toast("Erro: ID do produto não encontrado")
                return@setOnClickListener
            }
            val valor = edtValor.text.toString().toFloatOrNull()
            val peso = edtPeso.text.toString().toFloatOrNull()

            if (valor == null || peso == null) {
                toast("Valor e peso devem ser números válidos")
                return@setOnClickListener
            }

            val p = Confeitaria(
                id_produto = idProduto,
                nome = edtNome.text.toString(),
                valor = valor,
                peso = peso,
                descricao = edtDescricao.text.toString()
            )
            ui.launch {
                try {
                    withContext(Dispatchers.IO) { RetrofitClient.api.atualizarProduto(idProduto!!, p) }
                    toast("Produto atualizado com sucesso!")
                    finish()
                } catch (e: Exception) {
                    toast("Erro ao atualizar: ${e.message}")
                }
            }
        }
    }

    private fun toast(msg: String) =
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}