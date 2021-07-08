package com.task.pemrogramman_mobile_unsika

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class UD_Mahasiswa : AppCompatActivity() {

  private val env = Environment()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_u_d__mahasiswa)

    val toolbar = supportActionBar
    toolbar!!.title = "Detail Mahasiswa"
    toolbar.setDisplayHomeAsUpEnabled(true)

    val npm               = findViewById<EditText>(R.id.npm)
    val name              = findViewById<EditText>(R.id.nama)
    val rbGroupJk         = findViewById<RadioGroup>(R.id.rb_group_jk)
    val rb_jk_laki        = findViewById<RadioButton>(R.id.r_laki_laki)
    val rb_jk_perempuan   = findViewById<RadioButton>(R.id.r_perempuan)
    val prodi             = findViewById<Spinner>(R.id.cmb_prodi)
    val hobi1             = findViewById<CheckBox>(R.id.hobi_1)
    val hobi2             = findViewById<CheckBox>(R.id.hobi_2)
    val btnUpdate         = findViewById<Button>(R.id.btn_update)
    val btnDelete         = findViewById<Button>(R.id.btn_delete)

    var bundle    = intent.extras
    var getMhsId  = bundle!!.getString("mhs_id").toString()
    var getNpm    = bundle!!.getString("npm").toString()
    var getName   = bundle!!.getString("nama").toString()
    var getJK     = bundle!!.getString("jenis_kelamin").toString()
    var getProdi  = bundle!!.getString("prodi").toString()
    var getHobi   = bundle!!.getString("hobi").toString()

    var splitHobi = getHobi.split(",")

    var valueJenisKelamin   = ""
    var valueHobi           = ""

    npm.setText(getNpm)
    name.setText(getName)

    if (getJK == "Laki - Laki") {
      rb_jk_laki.isChecked = true
      valueJenisKelamin = "Laki - Laki"
    } else if (getJK == "Perempuan") {
      rb_jk_perempuan.isChecked = true
      valueJenisKelamin = "Perempuan"
    }

    rbGroupJk.setOnCheckedChangeListener { group, checkedId ->
      if (checkedId == R.id.r_laki_laki) {
        valueJenisKelamin = "Laki - Laki"
      } else if (checkedId == R.id.r_perempuan) {
        valueJenisKelamin = "Perempuan"
      }
    }

    if (getProdi == "Teknik Informatika") {
      prodi.setSelection(0)
    } else if (getProdi == "Sistem Informasi") {
      prodi.setSelection(1)
    }

    if (splitHobi.size == 2) {
      hobi1.isChecked = true
      hobi2.isChecked = true

      valueHobi = hobi1.text.toString() + ", " + hobi2.text.toString()
    } else if (splitHobi[0] == "Membaca Buku") {
      hobi1.isChecked = true
      valueHobi = hobi1.text.toString()
    } else if (splitHobi[0] == "Belajar Pemrograman") {
      hobi2.isChecked = true
      valueHobi = hobi2.text.toString()
    }

    btnUpdate.setOnClickListener {
      if (hobi1.isChecked && hobi2.isChecked) {
        valueHobi = hobi1.text.toString() + ", " + hobi2.text.toString()
      } else if (hobi1.isChecked) {
        valueHobi = hobi1.text.toString()
      } else if (hobi2.isChecked) {
        valueHobi = hobi2.text.toString()
      }

      val queue= Volley.newRequestQueue(this)
      val url = "${env.url}?params=mhs_update&mhs_id=${getMhsId}&npm=${npm.text}&nama=${name.text}&jenis_kelamin=${valueJenisKelamin}&prodi=${prodi.selectedItem}&hobi=${valueHobi}"

      val stringRequest = StringRequest(
        Request.Method.GET, url,
        Response.Listener<String> { response ->
          val obj = JSONObject(response)
          Toast.makeText(this, obj.getString("message"), Toast.LENGTH_SHORT).show()
        },
        Response.ErrorListener {
          Toast.makeText(this, "That didn't work!", Toast.LENGTH_SHORT).show()
        })

      queue.add(stringRequest)
      startActivity(Intent(this, ListMahasiswa::class.java))
    }

    btnDelete.setOnClickListener {
      delete(getMhsId)
      startActivity(Intent(this, ListMahasiswa::class.java))
    }

  }

  fun delete(id: String) {
    val queue = Volley.newRequestQueue(this)
    val url       = "${env.url}?params=mhs_delete&id=${id}"

    val stringRequest = StringRequest(
      Request.Method.GET, url,
      Response.Listener<String> { response ->
        val obj = JSONObject(response)
        Toast.makeText(this, obj.getString("message"), Toast.LENGTH_SHORT).show()
      },
      Response.ErrorListener {
        Toast.makeText(this, "That didn't work!", Toast.LENGTH_SHORT).show()
      })

    queue.add(stringRequest)
  }
}