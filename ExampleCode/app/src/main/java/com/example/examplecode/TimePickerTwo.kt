package com.example.examplecode

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.util.Calendar

class TimePickerTwo : AppCompatActivity() {
    private lateinit var tv_time: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_picker_two)

        val c = Calendar.getInstance()
        tv_time = findViewById(R.id.tv_time)

        tv_time.setOnClickListener{
            TimePickerDialog(this, { view, hourOfDay, minute ->
                tv_time.setText("$hourOfDay: $minute")
            }, c.get(Calendar.HOUR_OF_DAY),c.get(Calendar.MINUTE), true).show()
        }
    }
}