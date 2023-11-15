package com.example.sharedpreferencedemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

@Suppress("DEPRECATION")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val sessionManager= SessionManager(applicationContext)

        Handler().postDelayed({

            if(sessionManager.checkSession()){
                startActivity(Intent(this, ProfileActivity::class.java))
                finish()
            }
            else{
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        }, 1000)
    }
}