package com.example.whatsappclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.auth.FirebaseAuth

class AuthenticationActivity : AppCompatActivity(),FirebaseAuth.AuthStateListener{
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private val titles = arrayListOf("Log In","Sign Up")
    private lateinit var authPagerAdapter: AuthenticationPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)
        tabLayout = findViewById(R.id.tabLayoutAuthentication)
        viewPager = findViewById(R.id.viewPagerAuthentication)
        authPagerAdapter = AuthenticationPagerAdapter(this)
        viewPager.adapter = authPagerAdapter
        TabLayoutMediator(tabLayout, viewPager){
            tab, position->
            tab.text = titles[position]
        }.attach()

    }

    class AuthenticationPagerAdapter(fragmentActivity: FragmentActivity):FragmentStateAdapter(fragmentActivity) {
        override fun getItemCount(): Int {
            return 2
        }

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> LogIn()
                1 -> SignUp()
                else -> LogIn()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        FirebaseAuth.getInstance().addAuthStateListener(this)
        if(FirebaseAuth.getInstance().currentUser!=null){
            startMainActivity()
        }
    }

    override fun onAuthStateChanged(p0: FirebaseAuth) {
        if(p0.currentUser!=null){
            startMainActivity()
        }
    }

    override fun onStop() {
        super.onStop()
        FirebaseAuth.getInstance().removeAuthStateListener(this)
    }
    private fun startMainActivity(){
        val intent = Intent(this@AuthenticationActivity, MainActivity::class.java)
        startActivity(intent)
    }
}