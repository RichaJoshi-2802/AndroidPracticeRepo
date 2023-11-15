package com.example.fragmentdemo.demoTwo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.example.fragmentdemo.R
import com.example.fragmentdemo.demoTwo.fragment.Calls
import com.example.fragmentdemo.demoTwo.fragment.Chats
import com.example.fragmentdemo.demoTwo.fragment.Status
import com.google.android.material.tabs.TabLayout

class MainActivityTwo : AppCompatActivity() {

    private lateinit var tabLayoutTwo: TabLayout
    private lateinit var frameLayoutTwo: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_two)

        tabLayoutTwo = findViewById(R.id.tabLayoutTwo)
        frameLayoutTwo = findViewById(R.id.frameLayoutTwo)
        var transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayoutTwo, Chats()).commit()


        tabLayoutTwo.apply {
            addTab(
                tabLayoutTwo.newTab().also { its->
                    its.text = "Chats"
                    its.setIcon(R.drawable.chats)
                })

            addTab(
                tabLayoutTwo.newTab().also {its->
                    its.text = "Status"
                    its.setIcon(R.drawable.status)
                })

            addTab(
                tabLayoutTwo.newTab().also {its->
                    its.text = "Calls"
                    its.setIcon(R.drawable.call)
                })

            addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
                lateinit var fragment: Fragment
                override fun onTabSelected(tab: TabLayout.Tab?) {

                    when(tab?.position){
                        0-> fragment = Chats()
                        1-> fragment = Status()
                        2-> fragment = Calls()
                    }
                    transaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.frameLayoutTwo, fragment).commit()
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
                }

                override fun onTabReselected(tab: TabLayout.Tab?) {
                }

            })
        }
    }
}