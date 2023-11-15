package com.example.mediaservice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var btnStart: Button
    private lateinit var btnStop: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStart = findViewById<Button?>(R.id.btnStart).also {
            it.setOnClickListener {
                startService(Intent(this, NewService::class.java))
            }
        }
        btnStop = findViewById<Button?>(R.id.btnStop).also {
            it.setOnClickListener {
                startService(Intent(this, NewService::class.java))
            }
        }

    }

}

