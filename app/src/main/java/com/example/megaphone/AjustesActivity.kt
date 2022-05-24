package com.example.megaphone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AjustesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ajustes)

        val btn = findViewById<Button>(R.id.btnRegresar)

        btn.setOnClickListener {
            finish()
        }
    }
}