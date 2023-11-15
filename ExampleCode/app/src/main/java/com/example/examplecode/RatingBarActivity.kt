package com.example.examplecode

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import java.util.Calendar

class RatingBarActivity : AppCompatActivity() {
    private lateinit var myRatings:RatingBar
    private lateinit var tv_date:TextView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rating_bar)
        myRatings = findViewById(R.id.myRatings)

        val c = Calendar.getInstance()
        tv_date = findViewById(R.id.tv_date)
        tv_date.setOnClickListener{
            DatePickerDialog(this,
                { view, year, month, dayOfYear -> tv_date.text = "$dayOfYear-${month+1}-$year" },c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH)).show()
        }
    }

    fun getRatings(view: View) {
        val rating = myRatings.rating.toString()
        Toast.makeText(this, rating, Toast.LENGTH_SHORT).show()
    }

    fun getDay(view: View) {

        //Current date and time
        val c = Calendar.getInstance()
        val day = c.get(Calendar.DAY_OF_MONTH)
        val month = c.get(Calendar.MONTH)
        val year = c.get(Calendar.YEAR)

        Toast.makeText(this, "Today: $day $month $year", Toast.LENGTH_SHORT).show()
    }
}