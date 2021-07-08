package com.task.pemrogramman_mobile_unsika

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class ActivityDua : AppCompatActivity() {

  private val env = Environment()

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

      if (
        npm.text.toString() != "" &&
        nama.text.toString() != "" &&
        jenisKelamin != "" &&
        prodi.selectedItem.toString() != "" &&
        hobi != ""
      ) {
        val queue = Volley.newRequestQueue(this)
        val url       = "${env.url}?params=mhs_create&npm=${npm.text}&nama=${nama.text}&jenis_kelamin=${jenisKelamin}&prodi=${prodi.selectedItem}&hobi=${hobi}"

        val stringRequest = StringRequest(
          Request.Method.GET, url,
          Response.Listener<String> { response ->
            val obj = JSONObject(response)
            Toast.makeText(this, obj.getString("message"), Toast.LENGTH_SHORT).show()

            npm.text.clear()
            npm.text.clear()
            nama.text.clear()
            jk_laki.isChecked = false
            jk_perempuan.isChecked = false
            hobi1.isChecked = false
            hobi2.isChecked = false
          },
          Response.ErrorListener {
            Toast.makeText(this, "That didn't work!", Toast.LENGTH_SHORT).show()
          })

        queue.add(stringRequest)
      }

    }
  }
}