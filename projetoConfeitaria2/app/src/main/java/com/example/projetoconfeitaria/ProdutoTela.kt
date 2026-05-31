package com.example.projetoconfeitaria

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProdutoTela : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_produto_tela)

        val btn5 = findViewById<Button>(R.id.button5)
        val btn6 = findViewById<Button>(R.id.button6)

        btn5.setOnClickListener {
            val intent = Intent(this, CadastroProd::class.java)
            startActivity(intent)
        }

        btn6.setOnClickListener {
            val intent = Intent(this, ListaProd::class.java)
            startActivity(intent)
        }
    }
}