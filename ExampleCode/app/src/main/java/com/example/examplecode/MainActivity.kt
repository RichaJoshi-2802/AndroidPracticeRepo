package com.example.examplecode

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.Toast
import android.widget.Toast.*
import androidx.core.content.getSystemService

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        openCustom()
        setContentView(R.layout.activity_main)
        Log.d("Android", "The onCreate() event")

        findViewById<Button?>(R.id.btn2).setOnClickListener{
            stopService(Intent(this, MyService::class.java))
        }
    }

    override fun onStart() {
        super.onStart()
        makeText(this,"onStart Called", LENGTH_SHORT).show()
        Log.d("Android", "The onStart() event")
    }

    override fun onRestart() {
        super.onRestart()
        makeText(this,"onRestart Called", LENGTH_SHORT).show()
        Log.d("Android", "The onRestart() event")
    }

    override fun onResume() {
        super.onResume()
        makeText(this,"onResume Called", LENGTH_SHORT).show()
        Log.d("Android", "The onResume() event")
    }

    override fun onPause() {
        super.onPause()
        makeText(this,"onPause Called", LENGTH_SHORT).show()
        Log.d("Android", "The onPause() event")
    }

    override fun onStop() {
        super.onStop()
        makeText(this,"onStop Called", LENGTH_SHORT).show()
        Log.d("Android", "The onStop() event")
    }

    override fun onDestroy() {
        super.onDestroy()
        makeText(this,"onDestroy Called", LENGTH_SHORT).show()
        Log.d("Android", "The onDestroy() event")
    }

    fun broadcastIntent(view: View) {
        val intent = Intent(this, MyReceiver::class.java)
        intent.action = "com.example.CUSTOM_INTENT"
        sendBroadcast(intent)
    }
    fun startService(view: View) {
        startService(Intent(this, MyService::class.java))
    }

    private fun openCustom(){
        val xyz= this.getSystemService(Context.LAYOUT_INFLATER_SERVICE)
        val view:View = layoutInflater.inflate(R.layout.layout_custom_design, findViewById(R.id.linear_id))
        val t = Toast(this)
        t.duration = LENGTH_SHORT
        t.setGravity(Gravity.CENTER,0,0)
        t.view = view
        t.show()
    }
}