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

class ListMahasiswa : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_list_mahasiswa)

    getMahasiswa()
  }

  fun getMahasiswa() {
    val queue = Volley.newRequestQueue(this)
    val domain: String = "Enter your domain/ip address"
    val url: String = "${domain}/p-mobile-api/?params=mhs_view"
    val req = StringRequest(
      Request.Method.GET, url,
      Response.Listener <String>{
        response ->
        val list: ArrayList<String> = ArrayList()
        val list_mahasiswa = findViewById<ListView>(R.id.list_mahasiswa)
        val res = response.toString()
        val jsonObj: JSONObject = JSONObject(res)
        val jsonArray: JSONArray = jsonObj.getJSONArray("data")
        var dataMhs: String = ""

        for (i in 0 until jsonArray.length()) {
          var resultData: JSONObject = jsonArray.getJSONObject(i)
          dataMhs = "${resultData.get("npm")} \n ${resultData.get("nama")}"
          list.add(dataMhs)
        }

        list_mahasiswa.adapter = ArrayAdapter(this, simple_list_item_1, list)

      }, Response.ErrorListener {  })

    queue.add(req)
  }
}