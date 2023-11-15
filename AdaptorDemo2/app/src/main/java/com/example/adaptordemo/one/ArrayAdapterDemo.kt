package com.example.adaptordemo.one

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.adaptordemo.R

class ArrayAdapterDemo : AppCompatActivity() {
    private val names = arrayOf("Deepak","Amit","Deepesh","Priya","Sail","Kanika")
    private lateinit var listViewOne: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_array_adapter_demo)
        listViewOne = findViewById(R.id.listViewOne)

        listViewOne.adapter = ArrayAdapter<String>(this,
            R.layout.ui_view_two,
            R.id.textViewTwo, names)

    }
}           