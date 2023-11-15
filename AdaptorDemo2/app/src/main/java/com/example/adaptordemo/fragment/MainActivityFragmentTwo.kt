package com.example.adaptordemo.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.adaptordemo.R

class MainActivityFragmentTwo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_fragment_two)

        supportFragmentManager.beginTransaction().add(R.id.frameLayoutTwo, Login()).commit()
    }
}