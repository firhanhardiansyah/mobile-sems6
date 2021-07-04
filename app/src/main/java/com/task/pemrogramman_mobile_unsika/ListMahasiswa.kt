package com.task.pemrogramman_mobile_unsika

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject
import android.R.layout.simple_list_item_1
import android.content.Intent

class ListMahasiswa : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_list_mahasiswa)

    val toolbar = supportActionBar
    toolbar!!.title = "List Mahasiswa"
    toolbar.setDisplayHomeAsUpEnabled(true)

    getMahasiswa()
  }

  fun getMahasiswa() {
    val queue = Volley.newRequestQueue(this)
    val domain: String = "https://hanzdeveloper.000webhostapp.com"
    val url: String = "${domain}?params=mhs_view"
    val req = StringRequest(
      Request.Method.GET, url,
      Response.Listener <String>{
        response ->
        val list: ArrayList<String> = ArrayList()

        val list_mhs_id: ArrayList<String> = ArrayList()
        val list_npm: ArrayList<String> = ArrayList()
        val list_nama: ArrayList<String> = ArrayList()
        val list_jk: ArrayList<String> = ArrayList()
        val list_prodi: ArrayList<String> = ArrayList()
        val list_hobi: ArrayList<String> = ArrayList()

        val list_mahasiswa = findViewById<ListView>(R.id.list_mahasiswa)
        val res = response.toString()
        val jsonObj: JSONObject = JSONObject(res)
        val jsonArray: JSONArray = jsonObj.getJSONArray("data")
        var dataMhs: String = ""

        for (i in 0 until jsonArray.length()) {
          var resultData: JSONObject = jsonArray.getJSONObject(i)
          dataMhs = "${resultData.get("npm")} \n ${resultData.get("nama")}"
          list.add(dataMhs)

          list_mhs_id.add("${resultData.get("mhs_id")}")
          list_npm.add("${resultData.get("npm")}")
          list_nama.add("${resultData.get("nama")}")
          list_jk.add("${resultData.get("jenis_kelamin")}")
          list_prodi.add("${resultData.get("prodi")}")
          list_hobi.add("${resultData.get("hobi")}")
        }

        list_mahasiswa.adapter = ArrayAdapter(this, simple_list_item_1, list)

        list_mahasiswa.setOnItemClickListener { parent, view, position, id ->
          val bundle = Bundle()

          bundle.putString("mhs_id", list_mhs_id[position].toString())
          bundle.putString("npm", list_npm[position].toString())
          bundle.putString("nama", list_nama[position].toString())
          bundle.putString("jenis_kelamin", list_jk[position].toString())
          bundle.putString("prodi", list_prodi[position].toString())
          bundle.putString("hobi", list_hobi[position].toString())

          val intent = Intent(this, UD_Mahasiswa::class.java)
          intent.putExtras(bundle)
          this.startActivity(intent)
        }

      }, Response.ErrorListener {  })

    queue.add(req)
  }
}