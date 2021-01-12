package com.example.hw1.ui.login

import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.hw1.R
import com.squareup.okhttp.HttpUrl
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import java.io.IOException
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {
    private lateinit var service: ExecutorService
    private lateinit var client: OkHttpClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))


        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val mediaType = "application/json".toMediaType()
        val httpClient by lazy {
            OkHttpClient.Builder().build()
        }
        val bundle = intent.extras
        val username = bundle?.getString("username")
        val objectId = bundle?.getString("objectId")
        var token = bundle?.getString("sessionToken")
        val text1 = findViewById<TextView>(R.id.textView1)
        text1.setText("Email:" + username)


        val spinner = findViewById<Spinner>(R.id.spinner)
        val body = "{timezone:" + spinner.selectedItemPosition + "}"
        val lunch = arrayListOf("1", "2", "3", "4", "5")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, lunch)
        spinner.adapter = adapter
        fun putrequest1(num:Int,token:String){
            val mediaType = "application/json".toMediaType()
            val body = "{timezone:" + num + "}"
            val finalbody = body.toString()
            val url = "https://watch-master-staging.herokuapp.com/api/users/WkuKfCAdGq"

            fun httpPut(url: String, requestBody: String, token: String) {
                val request = Request.Builder()
                    .url(url)
                    // .header("X-Parse-Application-Id ", "vqYuKPOkLQLYHhk4QTGsGKFwATT4mBIGREI2m8eD")
                    .header("X-Parse-Session-Token", token)
                    .put(requestBody.toRequestBody(mediaType))
                    .build()
                try {
                    //val response = client.newCall(request).execute()
                    //System.out.println(response)

                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
            httpPut(url, finalbody, token)
        }
        putrequest1(spinner.selectedItemPosition,token.toString())

        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, pos: Int, id: Long) =
                Toast.makeText(this@MainActivity, "你選的是TimeZone是" + lunch[pos], Toast.LENGTH_SHORT).show()

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }


    }
}



fun putrequest11(num:Int,token:String){
    lateinit var service: ExecutorService
    lateinit var client: OkHttpClient
    val mediaType = "application/json".toMediaType()
    val httpClient by lazy {
        OkHttpClient.Builder().build()
    }
    val body = "{timezone:" + num + "}"
    val finalbody = body.toString()
    val url = "https://watch-master-staging.herokuapp.com/api/users/WkuKfCAdGq"

    fun httpPut(url: String, requestBody: String, token: String) {
        val request = Request.Builder()
            .url(url)
           // .header("X-Parse-Application-Id ", "vqYuKPOkLQLYHhk4QTGsGKFwATT4mBIGREI2m8eD")
            .header("X-Parse-Session-Token", token)
            .put(requestBody.toRequestBody(mediaType))
            .build()
        try {
            val response = client.newCall(request).execute()
            System.out.println(response)

        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
     //httpPut(url, finalbody, token)
}


