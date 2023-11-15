package com.example.volleydemo.retrofitdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.volleydemo.R
/*import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException*/
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        /*  Volley.newRequestQueue(this).add(JsonObjectRequest( Request.Method.GET,
            "https://jsonplaceholder.typicode.com/todos/1",
            null,
            { try{
                Log.d("myApp", "The response is ${it.getString("title")}")
                }catch (e:JSONException){ e.printStackTrace() }
            },
            {  Log.d("myApp","Something went wrong") })
         )*/

        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getProduct()
        retrofitData.enqueue(object : Callback<MyData?> {
            override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {
                val responseBody = response.body()
                val productList = responseBody?.products!!

                val collectDataInSB = StringBuilder()

                for (myData in productList){
                    collectDataInSB.append(myData.title)
                }
                findViewById<TextView>(R.id.idTVMsg).text = collectDataInSB
            }

            override fun onFailure(call: Call<MyData?>, t: Throwable) {
                Log.d("Main Activity", "onFailure: ${t.message}")
            }
        })
    }
}