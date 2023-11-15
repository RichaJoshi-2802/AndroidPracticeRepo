package com.example.sqlitedatabasedemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var regName:EditText
    private lateinit var regMail:EditText
    private lateinit var regPassword:EditText
    private lateinit var regGender:EditText
    private lateinit var register:Button
    private lateinit var goToLogin:Button
    private lateinit var dbHelper: DbHelper
    private lateinit var sm:SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dbHelper = DbHelper(this)
        sm = SessionManager(this)

        regName = findViewById(R.id.regName)
        regMail = findViewById(R.id.regMail)
        regPassword = findViewById(R.id.regPassword)
        regGender = findViewById(R.id.regGender)
        register = findViewById<Button?>(R.id.register).also {
            it.setOnClickListener {
                registerUser()
            }
        }

        goToLogin = findViewById<Button?>(R.id.goToLogin).also {
            it.setOnClickListener {
                startActivity(Intent(this, Login::class.java))
                finish()
            }
        }

    }

    private fun registerUser(){
        val name = regName.text.toString()
        val email = regMail.text.toString()
        val password = regPassword.text.toString()
        val gender = regGender.text.toString()
        val check = dbHelper.registerUserHelper(name, email, password, gender)

        if(check){
            Toast.makeText(this,"User registered successfully", Toast.LENGTH_SHORT).show()

            sm.createSession(name,email)
            val  intent = Intent(this, Profile::class.java)
            intent.putExtra("key_mail", email)
            startActivity(intent)
            finish()

//            regName.setText("")
//            regMail.setText("")
//            regPassword.setText("")
//            regGender.setText("")
        }
        else{
            Toast.makeText(this,"Error", Toast.LENGTH_SHORT).show()
        }
    }
}