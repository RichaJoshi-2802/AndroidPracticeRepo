package com.example.whatsappclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.FrameLayout
import androidx.appcompat.widget.Toolbar

class MenuActivity : AppCompatActivity() {
    private lateinit var toolbarMenu : Toolbar
    private lateinit var frameLayout : FrameLayout
    private lateinit var optionName: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        toolbarMenu = findViewById(R.id.toolbarMenu)
        frameLayout = findViewById(R.id.frameLayoutMenu)
        if(intent!=null){
            optionName = intent.getStringExtra("OptionName").toString()
            when(optionName){
                "profile"->{
                    supportFragmentManager.beginTransaction().replace(R.id.frameLayoutMenu, Profile()).commit()
                    toolbarMenu.title = "Profile"
                }
                "about"->{
                    supportFragmentManager.beginTransaction().replace(R.id.frameLayoutMenu, About()).commit()
                    toolbarMenu.title = "About Us"
                }
                "contacts"->{
                    supportFragmentManager.beginTransaction().replace(R.id.frameLayoutMenu, Contacts()).commit()
                    toolbarMenu.title = "Contacts"
                }
            }

        }
    }
}