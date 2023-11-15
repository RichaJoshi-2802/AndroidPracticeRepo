package com.example.adaptordemo.three

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.adaptordemo.R

class MainActivity : AppCompatActivity() {

    private lateinit var lvFour: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        lvFour = findViewById(R.id.lvFour)


    }
}