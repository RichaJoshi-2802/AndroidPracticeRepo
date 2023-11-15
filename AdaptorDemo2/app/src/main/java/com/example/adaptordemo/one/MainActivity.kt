package com.example.adaptordemo.one

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView
import android.widget.Toast
import com.example.adaptordemo.R

class MainActivity : AppCompatActivity() {

    private lateinit var gridViewOne: GridView
    private val images = intArrayOf(
        R.drawable.home,
        R.drawable.album,
        R.drawable.analytics,
        R.drawable.audiotrack,
        R.drawable.moon,
        R.drawable.hand
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(this,"onCreate Called",Toast.LENGTH_SHORT).show()

        gridViewOne = findViewById(R.id.gridViewOne)
        AdapterOne(this, images).also { gridViewOne.adapter = it }
    }
}