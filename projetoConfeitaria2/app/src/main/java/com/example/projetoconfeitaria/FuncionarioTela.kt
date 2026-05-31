package com.example.projetoconfeitaria

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FuncionarioTela : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_funcionario_tela)

        val btn3 = findViewById<Button>(R.id.button3)
        val btn4 = findViewById<Button>(R.id.button4)

        btn3.setOnClickListener {
            val intent = Intent(this, CadastroFunc::class.java)
            startActivity(intent)
        }

        btn4.setOnClickListener {
            val intent = Intent(this, ListaFunc::class.java)
            startActivity(intent)
        }
    }
}