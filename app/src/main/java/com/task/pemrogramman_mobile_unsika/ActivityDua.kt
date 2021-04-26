package com.task.pemrogramman_mobile_unsika

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class ActivityDua : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_dua)

    val toolbar = supportActionBar
    toolbar!!.title = "Activity Dua"
    toolbar.setDisplayHomeAsUpEnabled(true)

    val npm           = findViewById<EditText>(R.id.npm)
    val nama          = findViewById<EditText>(R.id.nama)
    val jk_laki       = findViewById<RadioButton>(R.id.r_laki_laki)
    val jk_perempuan  = findViewById<RadioButton>(R.id.r_perempuan)
    val prodi         = findViewById<Spinner>(R.id.cmb_prodi)
    val hobi1         = findViewById<CheckBox>(R.id.hobi_1)
    val hobi2         = findViewById<CheckBox>(R.id.hobi_2)

    var jenisKelamin  = ""
    var hobi          = ""

    val rbGroupJk     = findViewById<RadioGroup>(R.id.rb_group_jk)

    val btnProses     = findViewById<Button>(R.id.btn_proses)
    val txtHasil      = findViewById<TextView>(R.id.txt_hasil_proses)

    rbGroupJk.setOnCheckedChangeListener { group, checkedId ->
      if (checkedId == R.id.r_laki_laki) {
        jenisKelamin = "Laki - Laki"
      } else if (checkedId == R.id.r_perempuan) {
        jenisKelamin = "Perempuan"
      } else {
        jenisKelamin = "Jenis kelamin tidak ada"
      }
     }

    btnProses.setOnClickListener {
      if (hobi1.isChecked && hobi2.isChecked) {
        hobi = hobi1.text.toString() + ", " + hobi2.text.toString()
      } else if (hobi1.isChecked) {
        hobi = hobi1.text.toString()
      } else if (hobi2.isChecked) {
        hobi = hobi2.text.toString()
      }

      Toast.makeText(this, "Selesai", Toast.LENGTH_SHORT).show()

      txtHasil.text =
        "Npm  : " + npm.text + "\n" +
        "Nama : " + nama.text + "\n" +
        "Jenis Kelamin : " + jenisKelamin + "\n" +
        "Prodi : " + prodi.selectedItem.toString() + "\n" +
        "Hobi : " + hobi + "\n"
    }
  }
}