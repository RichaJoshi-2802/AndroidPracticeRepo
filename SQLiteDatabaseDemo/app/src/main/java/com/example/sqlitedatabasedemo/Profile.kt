package com.example.sqlitedatabasedemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class Profile : AppCompatActivity() {

    private lateinit var profileName:TextView
    private lateinit var profileMail:TextView
    private lateinit var profileGender:TextView
    private lateinit var updateProfile:ImageView
    private lateinit var deleteProfile:ImageView

    private lateinit var dbHelper: DbHelper
    private lateinit var sm:SessionManager

    private lateinit var profileLogout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        dbHelper = DbHelper(this)
        sm = SessionManager(this)

        profileName = findViewById(R.id.profileName)
        profileMail = findViewById(R.id.profileMail)
        profileGender = findViewById(R.id.profileGender)


        getUserDetails(intent.getStringExtra("key_mail")!!)

        findViewById<Button?>(R.id.profileLogout).also {
            it.setOnClickListener {
                AlertDialog.Builder(this).apply {
                    setTitle("Log Out")
                    setMessage("Are you sure you want to log out?")
                    setPositiveButton("Yes") { _, _ ->
                        logOutUser()
                    }
                    setNegativeButton("No") { dialog, _ ->
                        dialog.dismiss()
                    }
                    show()
                }
            }          
        }.also { profileLogout = it }

        updateProfile = findViewById<ImageView?>(R.id.updateProfile).also {
            it.setOnClickListener {
                updateUserProfile()
            }
        }

        deleteProfile = findViewById<ImageView?>(R.id.deleteProfile).also{
            it.setOnClickListener {
                AlertDialog.Builder(this).apply {
                    setTitle("Delete Account")
                    setMessage("Are you sure you want to delete your account?")
                    setPositiveButton("Yes") { _, _ ->
                        deleteProfile()
                    }
                    setNegativeButton("No") { dialog, _ ->
                        dialog.dismiss()
                    }
                    show()
                }
            }
        }
    }

    private fun logOutUser() {
        sm.logOutSession()
        startActivity(Intent(this, Login::class.java))
        Toast.makeText(this,"You are logged out!!!",Toast.LENGTH_SHORT).show()
    }

    private fun getUserDetails(email:String){
        Toast.makeText(this, "working", Toast.LENGTH_SHORT).show()
        dbHelper.getLoggedInUserDetails(email).also {
            profileName.text = it.name
            profileMail.text = it.email
            profileGender.text = it.gender
        }
    }

    private fun updateUserProfile(){
        startActivity(Intent(this, UpdateProfile::class.java).putExtra("key_data", dbHelper.getLoggedInUserDetails(
            intent.getStringExtra("key_mail")!!
        )))
    }

    private fun deleteProfile() {
        AlertDialog.Builder(this).also {
            it.setTitle("Delete Profile")
            it.setMessage("Are you sure you want to delete your profile ?")
            it.setNegativeButton("No") { _, _ -> }
            it.setPositiveButton("Yes") { _, _ ->
                val b = dbHelper.deleteProfileHelper(intent.getStringExtra("key_mail")!!)
                if (b) {
                    Toast.makeText(this, "Profile Deleted Successfully", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()

                }
            }
        }.show()
    }
}