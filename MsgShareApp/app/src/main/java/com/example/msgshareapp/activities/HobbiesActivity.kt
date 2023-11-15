package com.example.msgshareapp.activities;

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.msgshareapp.R
import com.example.msgshareapp.adapters.HobbiesAdapter
import com.example.msgshareapp.models.Supplier

class HobbiesActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hobbies)

        setUpRecyclerView()

        }

    private fun setUpRecyclerView() {
        //val layoutManager = LinearLayoutManager(this)
        //layoutManager.orientation = LinearLayoutManager.VERTICAL
        this.findViewById<RecyclerView>(R.id.recyclerView).layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        //val adapter =  HobbiesAdapter(this, Supplier.hobbies)
        findViewById<RecyclerView>(R.id.recyclerView).adapter = HobbiesAdapter(this, Supplier.hobbies)

    }
}