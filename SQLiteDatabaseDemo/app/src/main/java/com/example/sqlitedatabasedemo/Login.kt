package com.example.sqlitedatabasedemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Login : AppCompatActivity() {

    private lateinit var logMail:EditText
    private lateinit var logPassword:EditText
    private lateinit var login:Button
    private lateinit var goToRegister:Button
    private lateinit var dbHelper: DbHelper
    private lateinit var sm:SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        dbHelper = DbHelper(this)
        sm = SessionManager(this)

        logMail = findViewById(R.id.logMail)
        logPassword = findViewById(R.id.logPassword)
        login = findViewById<Button?>(R.id.login).also {
            it.setOnClickListener {
                loginUser()
            }
        }
        goToRegister = findViewById<Button?>(R.id.goToRegister).also {
            it.setOnClickListener {
                startActivity(Intent(this, MainActivity::class.java))
            }
        }
    }

    private fun loginUser(){
        val email = logMail.text.toString()
        val password = logPassword.text.toString()

        val loggedin = dbHelper.login(email, password)
        if(loggedin){
            sm.createSession(dbHelper.getLoggedInUserDetails(email).name!!,email)
            Toast.makeText(this, "Data exist", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, Profile::class.java).putExtra("key_mail", email))
            finish()
        }
        else{
            Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show()
        }
    }
}