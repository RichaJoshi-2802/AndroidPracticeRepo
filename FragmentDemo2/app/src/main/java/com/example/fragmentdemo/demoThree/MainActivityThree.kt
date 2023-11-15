package com.example.fragmentdemo.demoThree

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.fragmentdemo.R
import com.example.fragmentdemo.demoTwo.fragment.Calls
import com.example.fragmentdemo.demoTwo.fragment.Chats
import com.example.fragmentdemo.demoTwo.fragment.Status
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayoutMediator

class MainActivityThree : AppCompatActivity() {

    private lateinit var viewPagerThree: ViewPager2
    private lateinit var tabLayout: TabLayout
    private val titles = arrayListOf("Chats","Status","Calls")
    private val images = arrayListOf(R.drawable.chats, R.drawable.status, R.drawable.call)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_three)

        viewPagerThree = findViewById<ViewPager2?>(R.id.viewPagerThree).also {
            it.adapter = MyAdapterNew(supportFragmentManager, lifecycle) }

        tabLayout = findViewById(R.id.tabLayoutThree)

        TabLayoutMediator(tabLayout, viewPagerThree){
            tab, position->
            tab.text = titles[position]
            tab.setIcon(images[position])
        }.attach()

    }
}

class MyAdapterNew(fragmentManager: FragmentManager,lifecycle: Lifecycle):FragmentStateAdapter(fragmentManager, lifecycle){
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0-> Chats()
            1-> Status()
            2-> Calls()
            else-> Chats()
        }
    }

}
