package com.example.projetoconfeitaria

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.*
import kotlinx.coroutines.*

class AtualizarFunc : AppCompatActivity() {

    private val ui = CoroutineScope(Dispatchers.Main)
    private var idFuncionario: Int? = null  // guarda o ID recebido da lista

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_atualizar_func)

        val edtNome: EditText = findViewById(R.id.editNome2)
        val edtEmail: EditText = findViewById(R.id.editEmail2)
        val edtSenha: EditText = findViewById(R.id.editSenha2)
        val edtCargo: EditText = findViewById(R.id.editCargo2)
        val btnSalvar: Button = findViewById(R.id.buttonSalvar)

        // Recebe os dados que vieram da tela de lista
        idFuncionario = intent.getIntExtra("id", -1)
        edtNome.setText(intent.getStringExtra("nome"))
        edtEmail.setText(intent.getStringExtra("email"))
        edtSenha.setText(intent.getStringExtra("senha"))
        edtCargo.setText(intent.getStringExtra("cargo"))

        btnSalvar.setOnClickListener {
            if (idFuncionario == null || idFuncionario == -1) {
                toast("Erro: ID do funcionário não encontrado")
                return@setOnClickListener
            }
            val f = Funcionario(
                id_funcionario = idFuncionario,
                nome = edtNome.text.toString(),
                email = edtEmail.text.toString(),
                senha = edtSenha.text.toString(),
                cargo = edtCargo.text.toString()
            )
            ui.launch {
                try {
                    withContext(Dispatchers.IO) { RetrofitClient.api.atualizar(idFuncionario!!, f) }
                    toast("Atualizado com sucesso!")
                    finish() // volta pra tela de lista automaticamente
                } catch (e: Exception) {
                    toast("Erro ao atualizar: ${e.message}")
                }
            }
        }
    }

    private fun toast(msg: String) =
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

}