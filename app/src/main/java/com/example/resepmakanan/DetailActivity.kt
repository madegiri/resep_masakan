package com.example.resepmakanan

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    companion object {
        const val key_makanan = "EXTRA_MAKANAN"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val dataMakanan = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Makanan>(key_makanan, Makanan::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Makanan>(key_makanan)
        }

        val tvDetailName = findViewById<TextView>(R.id.tv_detail_name)
        val tvDetailDescription = findViewById<TextView>(R.id.tv_detail_description)
        val ivDetailPhoto = findViewById<ImageView>(R.id.iv_detail_photo)

        if (dataMakanan != null) {
            tvDetailName.text = dataMakanan.name
            tvDetailDescription.text = dataMakanan.description
            ivDetailPhoto.setImageResource(dataMakanan.photo)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)

        val shareItem = menu?.findItem(R.id.action_share)
        shareItem?.setOnMenuItemClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, "Check out this content!")
            }
            startActivity(Intent.createChooser(shareIntent, "Share via"))
            true
        }
        return true
    }
}
