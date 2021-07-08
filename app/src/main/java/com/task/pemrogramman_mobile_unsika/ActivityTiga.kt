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
      var info: String = """
          |${namaMK1.text} : ${nilaiMK1.text}
          |${namaMK2.text} : ${nilaiMK2.text}
          |${namaMK3.text} : ${nilaiMK3.text}
          |${namaMK4.text} : ${nilaiMK4.text}
          |${namaMK5.text} : ${nilaiMK5.text}
      """.trimMargin()

      resultMK.setText(info)
    }


  }
}