package com.example.sharedpreferencedemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    private lateinit var logEmail:EditText
    private lateinit var logPassword:EditText
    private lateinit var login:Button
    private lateinit var goToRegister: Button
    private lateinit var sm:SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sm = SessionManager(this)

        logEmail = findViewById(R.id.logEmail)
        logPassword = findViewById(R.id.logPassword)
        login = findViewById(R.id.login)
        goToRegister = findViewById(R.id.goToRegister)

        login.setOnClickListener {
            login()
        }

        goToRegister.setOnClickListener {
            goToRegister()
        }
    }

    private fun login(){
        val email = logEmail.text.toString()
        val password = logPassword.text.toString()

        if(email == "bbb@gmail.com" && password == "123456"){
            sm.createSession("bbb","bbb@gmail.com","1234567890")
            startActivity(Intent(this, ProfileActivity::class.java))
            finish()
        }
        else{
            Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show()
        }

    }

    private fun goToRegister(){
        startActivity(Intent(this, RegisterActivity::class.java))
        finish()
    }
}