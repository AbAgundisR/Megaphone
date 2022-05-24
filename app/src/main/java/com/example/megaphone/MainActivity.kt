package com.example.megaphone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    val sRed: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // start your next activity
        startActivity(Intent(this, LoginActivity::class.java))

        findViewById<Button>(R.id.btnMainAjustes).setOnClickListener {
            // start your next activity
            startActivity(Intent(this, AjustesActivity::class.java))
        }

        findViewById<Button>(R.id.btnMainFacebook).setOnClickListener {
            // start your next activity
            startActivity(Intent(this, FacebookActivity::class.java))
        }

        findViewById<Button>(R.id.btnMainTwitter).setOnClickListener {
            // start your next activity
            startActivity(Intent(this, TwitterActivity::class.java))
        }

        findViewById<Button>(R.id.btnMainInsta).setOnClickListener {
            // start your next activity
            startActivity(Intent(this, InstagramActivity::class.java))
        }
    }
}