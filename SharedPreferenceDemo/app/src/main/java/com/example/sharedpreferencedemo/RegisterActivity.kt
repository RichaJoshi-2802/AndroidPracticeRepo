package com.example.sharedpreferencedemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class RegisterActivity : AppCompatActivity() {

    private lateinit var regName:EditText
    private lateinit var regEmail:EditText
    private lateinit var regPassword:EditText
    private lateinit var regPhoneNo:EditText
    private lateinit var register:Button
    private lateinit var goToLogin: Button
    private lateinit var sm:SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        sm = SessionManager(this)

        regName = findViewById(R.id.regName)
        regEmail = findViewById(R.id.regEmail)
        regPassword = findViewById(R.id.regPassword)
        regPhoneNo = findViewById(R.id.regPhoneNo)
        register = findViewById(R.id.register)
        goToLogin = findViewById(R.id.goToLogin)

        register.setOnClickListener {
            register()
        }

        goToLogin.setOnClickListener {
            goToLogin()
        }

    }

    private fun register(){

        val name = regName.text.toString()
        val email = regEmail.text.toString()
        //val password = regPassword.text.toString()
        val phno = regPhoneNo.text.toString()

        //insert into database
        sm.createSession(name,email, phno)
        val  intent = Intent(this, ProfileActivity::class.java)
        startActivity(intent)
        finish()
    }


    private fun goToLogin() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}