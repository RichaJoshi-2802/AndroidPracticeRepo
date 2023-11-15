package com.example.whatsappclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var viewPager2: ViewPager2
    private lateinit var tabLayout: TabLayout
    private lateinit var toolbar: androidx.appcompat.widget.Toolbar
    private lateinit var appPagerAdapter: AppPagerAdapter
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var showContacts: FloatingActionButton
    private val titles = arrayListOf("Chats","Status","Calls")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar = findViewById(R.id.toolbarMain)
        tabLayout = findViewById(R.id.tabLayoutMain)
        showContacts = findViewById(R.id.btContacts)
        viewPager2 = findViewById(R.id.viewPager2Main)
        firebaseAuth = FirebaseAuth.getInstance()
        setSupportActionBar(toolbar)
        appPagerAdapter = AppPagerAdapter(this)
        viewPager2.adapter = appPagerAdapter
        TabLayoutMediator(tabLayout, viewPager2){
            tab, position->
            tab.text = titles[position]
        }.attach()

        showContacts.setOnClickListener{
            val intent = Intent(this, MenuActivity::class.java)
            intent.putExtra("OptionName","contacts")
            startActivity(intent)
        }
    }

    class AppPagerAdapter(fragmentActivity: FragmentActivity):FragmentStateAdapter(fragmentActivity){
        override fun getItemCount(): Int {
            return 3
        }

        override fun createFragment(position: Int): Fragment {
            return when(position){
                0->Chats()
                1->Status()
                3->Calls()
                else->Chats()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.profile-> {
                val intent = Intent(this, MenuActivity::class.java)
                intent.putExtra("OptionName", "profile")
                startActivity(intent)
            }
            R.id.aboutUs-> {
                val intent = Intent(this, MenuActivity::class.java)
                intent.putExtra("OptionName","about")
                startActivity(intent)
            }
            R.id.logOut-> {
                firebaseAuth.signOut()
                val intent = Intent(this, AuthenticationActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}



/* view_bg.xml
<gradient
        android:startColor="#8F017B"
        android:endColor="#0232A8"
        android:angle="45"
        android:centerColor="#582E9C"/>

        <stroke
        android:width="5dp"
        android:color="#1A3951"/>

 */