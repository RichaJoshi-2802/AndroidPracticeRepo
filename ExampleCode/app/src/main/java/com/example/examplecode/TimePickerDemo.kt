package com.example.examplecode

import android.os.Bundle
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TimePickerDemo : AppCompatActivity() {
    private lateinit var timePicker: TimePicker
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_picker_demo)
        timePicker = findViewById(R.id.timePicker)

        timePicker.setOnTimeChangedListener { view, hourOfDay, minute ->
            Toast.makeText(this, "$hourOfDay: $minute", Toast.LENGTH_SHORT).show()
        }
    }
}