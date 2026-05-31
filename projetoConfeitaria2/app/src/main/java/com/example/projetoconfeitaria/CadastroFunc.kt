package com.example.projetoconfeitaria

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.*
import kotlinx.coroutines.*

class CadastroFunc : AppCompatActivity() {

    private val ui = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_func)

        val edtNome: EditText = findViewById(R.id.editNome2)
        val edtEmail: EditText = findViewById(R.id.editEmail2)
        val edtSenha: EditText = findViewById(R.id.editSenha2)
        val edtCargo: EditText = findViewById(R.id.editCargo2)
        val btnSalvar: Button = findViewById(R.id.buttonSalvar)

        btnSalvar.setOnClickListener {
            val f = Funcionario(
                nome = edtNome.text.toString(),
                email = edtEmail.text.toString(),
                senha = edtSenha.text.toString(),
                cargo = edtCargo.text.toString()
            )
            ui.launch {
                try {
                    withContext(Dispatchers.IO) { RetrofitClient.api.criar(f) }
                    toast("Cadastrado com sucesso")
                    limpar(edtNome, edtEmail, edtSenha, edtCargo)
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