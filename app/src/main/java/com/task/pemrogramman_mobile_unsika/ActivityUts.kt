package com.task.pemrogramman_mobile_unsika

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.lang.StringBuilder

class ActivityUts : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_uts)

    val toolbar = supportActionBar
    toolbar!!.title = "UTS"
    toolbar.setDisplayHomeAsUpEnabled(true)

    val namaKaryawan        = findViewById<EditText>(R.id.nama_karyawan)
    val umurKaryawan        = findViewById<EditText>(R.id.umur_karyawan)
    val rbGroupJkKaryawan   = findViewById<RadioGroup>(R.id.rb_group_jk_karyawan)
    val cmbMasaKerja        = findViewById<Spinner>(R.id.cmb_masa_kerja)

    val hobiOlahraga        = findViewById<CheckBox>(R.id.hobi_olahraga)
    val hobiMembaca         = findViewById<CheckBox>(R.id.hobi_membaca)
    val hobiJlnJln          = findViewById<CheckBox>(R.id.hobi_jln_jln)
    val hobiBelanja         = findViewById<CheckBox>(R.id.hobi_belanja)

    val btnProsesUts         = findViewById<Button>(R.id.btn_proses_uts)

    var jenisKelamin:String = ""

    rbGroupJkKaryawan.setOnCheckedChangeListener { group, checkedId ->
      if (checkedId == R.id.rb_laki_laki) {
        jenisKelamin = "Laki - Laki"
      } else if (checkedId == R.id.rb_perempuan) {
        jenisKelamin = "Perempuan"
      }
    }

    btnProsesUts.setOnClickListener {
      val hobiSelected        = StringBuilder()
      var tunjangan:Int       = 0
      var outputUTS:String    = ""

      if (jenisKelamin == "Laki - Laki") {
        tunjangan = 1000
      } else if (jenisKelamin == "Perempuan") {
        tunjangan = 1500
      }

      if ((cmbMasaKerja.selectedItem.toString() >= "5") || (cmbMasaKerja.selectedItem.toString() <= "10") ) {
        tunjangan += 500
      } else if ((cmbMasaKerja.selectedItem.toString() >= "10") || (cmbMasaKerja.selectedItem.toString() <= "20") ) {
        tunjangan += 1000
      }

      if (hobiOlahraga.isChecked) {
        hobiSelected.appendLine(" - " + hobiOlahraga.text)
        tunjangan += 100
      }

      if (hobiMembaca.isChecked) {
        hobiSelected.appendLine(" - " + hobiMembaca.text)
        tunjangan += 100
      }

      if (hobiJlnJln.isChecked) {
        hobiSelected.appendLine(" - " + hobiJlnJln.text)
        tunjangan += 100
      }

      if (hobiBelanja.isChecked) {
        hobiSelected.appendLine(" - " + hobiBelanja.text)
        tunjangan += 100
      }

      outputUTS =
        "Nama Karyawan : " + namaKaryawan.text + "\n" +
            "Umur Karyawan : " + umurKaryawan.text + "\n" +
            "Jenis Kelamin : " + jenisKelamin + "\n" +
            "Masa Kerja : " + cmbMasaKerja.selectedItem.toString() + "\n" +
            "Hobi : "  + "\n" + hobiSelected.toString() +
            "Tunjangan yang diproleh : " + tunjangan

      message(outputUTS)
    }
  }

  fun message(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
  }

}