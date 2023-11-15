package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataset = listOf (
            Student("Priyansh", "23245"),
            Student("Shruti", "32156"),
            Student("Rishita", "94356"),
            Student("Reshma", "23245"),
            Student("Rishi", "23245"),
        )
        val customAdapter = CustomAdapter(this, dataset)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = GridLayoutManager(this, 3, RecyclerView.HORIZONTAL, false)
        recyclerView.adapter = customAdapter

    }
}

data class Student(val name:String, val phno:String)