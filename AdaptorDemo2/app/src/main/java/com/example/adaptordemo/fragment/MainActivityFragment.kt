package com.example.adaptordemo.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import com.example.adaptordemo.R

class MainActivityFragment : AppCompatActivity() {
    private lateinit var frameLayoutOne: FragmentContainerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_fragment)

        frameLayoutOne = findViewById(R.id.frameLayoutOne)
        supportFragmentManager.beginTransaction().add(R.id.frameLayoutOne, FragmentOne()).commit()
    }
}