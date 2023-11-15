package com.example.examplecode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.Toast

class MyForm : AppCompatActivity() {
    private lateinit var et_name:EditText
    private lateinit var et_password:EditText
    private lateinit var et_phone:EditText
    private lateinit var rb_male:RadioButton
    private lateinit var rb_female:RadioButton
    private lateinit var cb_android:CheckBox
    private lateinit var cb_java:CheckBox
    private lateinit var cb_python:CheckBox
    private lateinit var sp_cities: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_form)
        et_name = findViewById(R.id.et_name)
        et_password= findViewById(R.id.et_password)
        et_phone = findViewById(R.id.et_phone)
        rb_male = findViewById(R.id.rb_male)
        rb_female = findViewById(R.id.rb_female)
        cb_android = findViewById(R.id.cb_android)
        cb_java = findViewById(R.id.cb_java)
        cb_python = findViewById(R.id.cb_python)
        sp_cities = findViewById(R.id.sp_cities)

    }

    fun getAllValues(view:View) {
        val name = et_name.text.toString()
        val password = et_password.text.toString()
        val phone = et_phone.text.toString()
        val gender = when {
            rb_female.isChecked -> rb_female.text.toString()
            else-> rb_male.text.toString()
        }

        var interest = ""
        if(cb_android.isChecked)
            interest+= "${cb_android.text}\n"
        if(cb_java.isChecked)
            interest+= "${cb_java.text}\n"
        if(cb_python.isChecked)
            interest+="${cb_python.text}\n"

        val city = sp_cities.selectedItem.toString()

        val res = buildString {
        append("$name\n")
        append("$password\n")
        append("$phone\n")
        append("$gender\n")
        append("$interest\n")
        append(city)
    }

        Toast.makeText(this,res,Toast.LENGTH_SHORT).show()
    }
}