package com.example.adaptordemo.two

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.example.adaptordemo.R

class MainActivityTwo : AppCompatActivity(){

    private val names = arrayOf("Deepak","Amit","Deepesh","Priya","Sahil","Kanika")
    private lateinit var spinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_two)

        spinner = findViewById(R.id.spinnerTwo)

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(this@MainActivityTwo, "Name is ${names[position]}", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

        }

        spinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, names)

    }


}