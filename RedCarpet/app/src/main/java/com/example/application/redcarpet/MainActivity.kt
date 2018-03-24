package com.example.application.redcarpet

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.telecom.Call
import android.widget.LinearLayout
import android.widget.Toast
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    //    recyclerView_main.setBackgroundColor(Color.BLUE);

    //    recyclerView_main.layoutManager = LinearLayoutManager(this,LinearLayout.VERTICAL,false);

       // val users = ArrayList<User>()

       // recyclerView_main.adapter = MainAdapter();

        fetchJson();
    }


    fun fetchJson() {

        val url = "http://api.letsbuildthatapp.com/youtube/home_feed"
        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()

        client.newCall(request).enqueue(object: Callback{

            override fun onResponse(call: okhttp3.Call?, response: Response?) {
            val body = response?.body()?.string()   //See it carefully wasted my 30 mins on this line
                println(body)

                val gson = GsonBuilder().create()
                val homeFeed = gson.fromJson(body,HomeFeed::class.java)

                runOnUiThread {
                    recyclerView_main.layoutManager = LinearLayoutManager(baseContext)
                    recyclerView_main.adapter = MainAdapter(homeFeed)
                }
            }

            override fun onFailure(call: okhttp3.Call?, e: IOException?) {
                Toast.makeText(this@MainActivity, "Error Occured",
                        Toast.LENGTH_LONG).show()
            }
        })
    }


    class HomeFeed(val videos:List<Video>)

    class Video(val id:Int, val name: String,val link:String, val imageUrl:String, val numberOfViews: Int,
                val channel: Channel)

    class Channel(val name:String, val profileImageUrl :String)
}
