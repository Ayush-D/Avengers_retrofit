package com.example.application.retrofit

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import retrofit2.Retrofit
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory
import android.widget.ArrayAdapter
import com.google.gson.GsonBuilder


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Practising for /retrofit in Kotlin -> 1. Data Class [POJO].  2.Interface 3. Handle in MainActivity

        //Creating a retrofit object
        val retrofit = Retrofit.Builder()
                .baseUrl("https://simplifiedcoding.net/demos/")
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build()

        //creating the api interface
        val api = retrofit.create(Api::class.java)  //:: class as data type

        //now making the call object
        //Here we are using the api method that we created inside the api interface
        val call = api.getHeroes()

        call.enqueue(object : Callback<List<Hero>> {
            override fun onResponse(call: Call<List<Hero>>, response: Response<List<Hero>>) {

                val body = response?.body()
                //See in logcat it will print all the data at website :)
                println(body)

                val contacts: List<Hero> = response?.body()!!

                //val gson = GsonBuilder().create()
                //gson.fromJson(body, List(Hero))

                val githubUserAdapter = CustomAdapter(contacts)

                recyclerView.layoutManager = LinearLayoutManager(baseContext)

                recyclerView.adapter = githubUserAdapter
            }

            override fun onFailure(call: Call<List<Hero>>, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }
}
