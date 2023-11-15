package com.example.fragmentdemo.demoOne.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.fragmentdemo.demoOne.fragments.FragmentOne
import com.example.fragmentdemo.demoOne.fragments.FragmentThree
import com.example.fragmentdemo.demoOne.fragments.FragmentTwo

class MyAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0-> FragmentOne()
            1-> FragmentTwo()
            2-> FragmentThree()
            else -> FragmentOne()
        }
    }

}