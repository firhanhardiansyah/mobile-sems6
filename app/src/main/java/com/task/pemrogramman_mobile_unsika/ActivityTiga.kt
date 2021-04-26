package com.task.pemrogramman_mobile_unsika

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class ActivityTiga : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_tiga)

    val toolbar = supportActionBar
    toolbar!!.title = "Activity Tiga"
    toolbar.setDisplayHomeAsUpEnabled(true)

    val namaMK1   = findViewById<EditText>(R.id.nama_mk1)
    val nilaiMK1  = findViewById<EditText>(R.id.nilai_mk1)

    val namaMK2   = findViewById<EditText>(R.id.nama_mk2)
    val nilaiMK2  = findViewById<EditText>(R.id.nilai_mk2)

    val namaMK3   = findViewById<EditText>(R.id.nama_mk3)
    val nilaiMK3  = findViewById<EditText>(R.id.nilai_mk3)

    val namaMK4   = findViewById<EditText>(R.id.nama_mk4)
    val nilaiMK4  = findViewById<EditText>(R.id.nilai_mk4)

    val namaMK5   = findViewById<EditText>(R.id.nama_mk5)
    val nilaiMK5  = findViewById<EditText>(R.id.nilai_mk5)

    val resultMK  = findViewById<TextView>(R.id.txt_hasil_proses_mk)

    val btnProsesMK = findViewById<Button>(R.id.btnProsesMk)

    btnProsesMK.setOnClickListener {
      resultMK.setText(
        namaMK1.text.toString() + " : " + nilaiMK1.text + "\n" +
        namaMK2.text.toString() + " : " + nilaiMK2.text + "\n" +
        namaMK3.text.toString() + " : " + nilaiMK3.text + "\n" +
        namaMK4.text.toString() + " : " + nilaiMK4.text + "\n" +
        namaMK5.text.toString() + " : " + nilaiMK5.text + "\n"
      )
    }


  }
}