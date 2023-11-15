package com.example.seekbardemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var textView:TextView
    private lateinit var listview: ListView
    private lateinit var seekBar: SeekBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        listview = findViewById(R.id.listview)
        seekBar = findViewById(R.id.seekBar)
        seekBar.max = 20
        seekBar.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                Toast.makeText(this@MainActivity, "The progress is $progress", Toast.LENGTH_SHORT).show()
                populate(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

    }
    fun populate(table:Int){
        val mulTable = ArrayList<String>()
        for (i in 1..10){
            mulTable.add("$table X $i = ${table*i}")
        }
        listview.adapter =ArrayAdapter(this,android.R.layout.simple_list_item_1, mulTable)
    }
}