package com.example.sqlitedatabasedemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

@Suppress("DEPRECATION")
class UpdateProfile : AppCompatActivity() {

    private lateinit var updateEmail:TextView
    private lateinit var updateName:TextView
    private lateinit var updateGender:TextView
    private lateinit var updateProfile: Button
    private lateinit var dbHelper: DbHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_profile)

        dbHelper = DbHelper(this)

        updateEmail = findViewById(R.id.updateEmail)
        updateName = findViewById(R.id.updateName)
        updateGender = findViewById(R.id.updateGender)
        updateProfile = findViewById<Button?>(R.id.updateProfile).also {
            it.setOnClickListener {
                updateUserProfile()
            }
        }

        intent.getParcelableExtra<UserModal>("key_data").also {
            updateEmail.text = it!!.email
            updateName.text = it.name
            updateGender.text = it.gender
        }

    }

    private fun updateUserProfile() {
        val i =dbHelper.updateProfileHelper(updateName.text.toString(), updateEmail.text.toString(), updateGender.text.toString())
        if(i){
            Toast.makeText(this,"Updated Successfully",Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, Profile::class.java))
        }else{
            Toast.makeText(this,"Error occurred",Toast.LENGTH_SHORT).show()
        }
 }
}