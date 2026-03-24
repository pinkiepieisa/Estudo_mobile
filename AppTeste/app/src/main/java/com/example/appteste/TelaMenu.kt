package com.example.appteste

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TelaMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tela_menu)

        var btnex2 = findViewById<Button>(R.id.button2)
        var btnex3 = findViewById<Button>(R.id.button3)
        var btnex4 = findViewById<Button>(R.id.button4)
        var btnex7 = findViewById<Button>(R.id.button5)
        var btnex8 = findViewById<Button>(R.id.button6)
        var btnex9 = findViewById<Button>(R.id.button9)


        btnex2.setOnClickListener {
            var in2 = Intent(this, Atividade2::class.java)
            startActivity(in2)
        }

        btnex3.setOnClickListener {
            var in3 = Intent(this, Atividade3::class.java)
            startActivity(in3)
        }

        btnex4.setOnClickListener {
            var in4 = Intent(this, Atividade4::class.java)
            startActivity(in4)
        }

        btnex7.setOnClickListener {
            var in7 = Intent(this, Atividade7::class.java)
            startActivity(in7)
        }

        btnex8.setOnClickListener {
            var in8 = Intent(this, Atividade8::class.java)
            startActivity(in8)
        }

        btnex9.setOnClickListener {
            var in9 = Intent(this, TelaMapa::class.java)
            startActivity(in9)
        }
    }
}