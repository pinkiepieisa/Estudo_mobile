package com.example.projetoconfeitaria

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.*
import kotlinx.coroutines.*

class CadastroProd : AppCompatActivity() {

    private val ui = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_prod)

        val edtNome: EditText = findViewById(R.id.editNomeProd)
        val edtValor: EditText = findViewById(R.id.editValorProd)
        val edtPeso: EditText = findViewById(R.id.editPesoProd)
        val edtDescricao: EditText = findViewById(R.id.editDescricaoProd)
        val btnSalvar: Button = findViewById(R.id.btnSalvarProd)

        btnSalvar.setOnClickListener {
            val valor = edtValor.text.toString().toFloatOrNull()
            val peso = edtPeso.text.toString().toFloatOrNull()

            if (valor == null || peso == null) {
                toast("Valor e peso devem ser números válidos")
                return@setOnClickListener
            }

            val p = Confeitaria(
                nome = edtNome.text.toString(),
                valor = valor,
                peso = peso,
                descricao = edtDescricao.text.toString()
            )
            ui.launch {
                try {
                    withContext(Dispatchers.IO) { RetrofitClient.api.criarProduto(p) }
                    toast("Produto cadastrado com sucesso!")
                    limpar(edtNome, edtValor, edtPeso, edtDescricao)
                } catch (e: Exception) {
                    toast("Erro ao salvar: ${e.message}")
                }
            }
        }
    }

    private fun limpar(vararg campos: EditText) {
        campos.forEach { it.setText("") }
    }

    private fun toast(msg: String) =
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}