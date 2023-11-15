package com.example.sharedpreferencedemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class ProfileActivity : AppCompatActivity() {


    private lateinit var proName: TextView
    private lateinit var logOut:Button
    private lateinit var sm:SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        sm = SessionManager(this)

        proName = findViewById<TextView?>(R.id.proName).apply {

            text = sm.getSessionDetails("key_session_name")
        }

        logOut =findViewById<Button?>(R.id.logOut).also { it.setOnClickListener { logOut() } }

    }

    private fun logOut(){
        sm.logOutSession()
        startActivity(Intent(this, LoginActivity::class.java))
        Toast.makeText(this,"You are logged out!!!",Toast.LENGTH_SHORT).show()
    }
}