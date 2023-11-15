package com.example.msgshareapp.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.msgshareapp.R
import com.example.msgshareapp.showToast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnShowToast).setOnClickListener{
            Log.i("MainActivity", resources.getString(R.string.btn_clicked))
            showToast(resources.getString(R.string.btn_clicked))
        }

        findViewById<Button>(R.id.sendMessage).setOnClickListener{
            val msg:String = findViewById<TextView>(R.id.etMessage).text.toString()
            showToast(msg, Toast.LENGTH_LONG)

            val intent = Intent(this, SecondActivity::class.java) //Explicit intent: known target activity
            intent.putExtra("user_msg", msg)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btnShareToOther).setOnClickListener{
            val msg:String = findViewById<TextView>(R.id.etMessage).text.toString()

            val intent = Intent().apply {
                action = Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT, msg)
                type = "text/plain"
            }//implicit intent: unknown target activity

            startActivity(Intent.createChooser(intent,"Select from Option-"))
        }

        findViewById<Button>(R.id.btnRecycleViewDemo).setOnClickListener{
            val intent = Intent(this, HobbiesActivity::class.java)
            startActivity(intent)
        }
    }
}