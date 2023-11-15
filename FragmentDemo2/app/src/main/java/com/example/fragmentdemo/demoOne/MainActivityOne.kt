package com.example.fragmentdemo.demoOne

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.fragmentdemo.R
import com.example.fragmentdemo.demoOne.adapter.MyAdapter

class MainActivityOne : AppCompatActivity() {

    private lateinit var viewPager2: ViewPager2
    private  val myAdapter = MyAdapter(supportFragmentManager,lifecycle)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_one)

        viewPager2 = findViewById(R.id.viewPager2)
        viewPager2.adapter = myAdapter

    }

}