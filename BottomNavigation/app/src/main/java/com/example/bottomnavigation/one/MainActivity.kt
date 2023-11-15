package com.example.bottomnavigation.one

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.bottomnavigation.R
import com.example.bottomnavigation.one.fragments.Home
import com.example.bottomnavigation.one.fragments.Messages
import com.example.bottomnavigation.one.fragments.Profile
import com.example.bottomnavigation.one.fragments.Settings
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener

class MainActivity : AppCompatActivity() {

    //private lateinit var frameLayoutOne: FrameLayout
    private lateinit var btmNavigationView: BottomNavigationView
    private lateinit var myViewPager : ViewPager2
    private val myAdapter = MyViewPager(supportFragmentManager,lifecycle)

    class MyViewPager(fragmentManager: FragmentManager,lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {
        override fun getItemCount(): Int {
            return 4
        }

        override fun createFragment(position: Int): Fragment {
            return when(position){
                0-> Home()
                1->Profile()
                2->Messages()
                3->Settings()
                else->Home()
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //frameLayoutOne = findViewById(R.id.frameLayoutOne)
        btmNavigationView = findViewById(R.id.bottomNavigationView)
        myViewPager = findViewById(R.id.myViewPager)
        myViewPager.adapter = myAdapter

        //supportFragmentManager.beginTransaction().add(R.id.frameLayoutOne, Home()).commit()
        btmNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.homeOne -> {
                    myViewPager.currentItem = 0

                    true // Return true to indicate that the item has been handled
                }
                R.id.profileOne -> {
                    myViewPager.currentItem = 1
                    // Handle Dashboard item click
                    true
                }
                R.id.messageOne -> {
                    myViewPager.currentItem = 2
                    // Handle Notifications item click
                    true
                }
                R.id.settingsOne -> {
                    myViewPager.currentItem = 3
                    // Handle Notifications item click
                    true
                }
                else -> false
            }
        }

        myViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                btmNavigationView.menu.getItem(position).isChecked = true
            }
        })

    }
}