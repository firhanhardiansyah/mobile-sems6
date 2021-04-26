package com.task.pemrogramman_mobile_unsika

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tombolSatu          = findViewById<Button>(R.id.tombol_satu)
        val textSatu            = findViewById<TextView>(R.id.text_satu)
        val tombolActivityDua   = findViewById<Button>(R.id.tombol_activity_dua)
        val tombolActivityTiga  = findViewById<Button>(R.id.tombol_activity_tiga)

        tombolSatu.setOnClickListener {
            Toast.makeText(this, "Ini proses dari klik tombol", Toast.LENGTH_LONG).show()
            textSatu.text = "Ini berubah setelah button satu diklik"
        }

        tombolActivityDua.setOnClickListener {
            startActivity(Intent(this, ActivityDua::class.java))
        }

        tombolActivityTiga.setOnClickListener {
            startActivity(Intent(this, ActivityTiga::class.java))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_pertama, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        when(id) {
            R.id.menu_satu -> {
                startActivity(Intent(this, ActivityDua::class.java))
            }
        }
        return true
    }
}