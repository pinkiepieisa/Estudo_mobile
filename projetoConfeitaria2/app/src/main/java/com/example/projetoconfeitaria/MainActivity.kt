package com.example.projetoconfeitaria

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btn1 = findViewById<Button>(R.id.button)
        val btn2 = findViewById<Button>(R.id.button2)

        btn1.setOnClickListener {
            val intent = Intent(this, ProdutoTela::class.java)
            startActivity(intent)
        }

        btn2.setOnClickListener {
            val intent = Intent(this, FuncionarioTela::class.java)
            startActivity(intent)
        }
    }
}