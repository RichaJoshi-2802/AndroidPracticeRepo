package com.example.msgshareapp.activities

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.msgshareapp.R
import com.example.msgshareapp.showToast

class SecondActivity:AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val bundle:Bundle? = intent.extras
        bundle?.let {
            val msg = bundle!!.getString("user_msg")
            msg?.let { it1 -> showToast(it1) }
            findViewById<TextView>(R.id.txtUserMessage).text = msg
        }
    }
}