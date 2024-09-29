package com.example.resepmakanan

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        enableEdgeToEdge()
        setContentView(R.layout.activity_about)

        val profileName = findViewById<TextView>(R.id.profileName)
        val profileEmail = findViewById<TextView>(R.id.profileEmail)

        profileName.text = "Made Dharmagiri"
        profileEmail.text = "a128b4ky2370@bangkit.academy"
    }
}