package com.example.sqlitedatabasedemo

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
        val email = sessionManager.getSessionDetails("key_session_mail")

        Handler().postDelayed({

            if(sessionManager.checkSession()){
                startActivity(Intent(this, Profile::class.java).putExtra("key_mail",email!!))
                finish()
            }
            else{
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }, 1000)
    }
}