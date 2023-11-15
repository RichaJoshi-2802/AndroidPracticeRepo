package com.example.sharedpreferencedemo

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences

class SessionManager(private val context: Context) {

    private val sp:SharedPreferences
    private val editor: SharedPreferences.Editor
    private val prefFileName = "shopping"
    private val privateMode = 0

    //Key initialization for Shared preference editor
    private var keyIfLoggedin = "key_session_if_logged_in"
    private val keyName = "key_session_name"
    private val keyMail= "key_session_mail"
    private val keyPhno = "key_session_phno"

    init {
        sp = context.getSharedPreferences(prefFileName, privateMode)  //Initialization of shared preferences
        editor = sp.edit()
    }

    fun createSession(name:String, email:String, phno:String){
        // store data in shared preference file: editor.putString(key, value).commit()
        editor.putString(keyName, name)
        editor.putString(keyMail,email)
        editor.putString(keyPhno, phno)
        editor.putBoolean(keyIfLoggedin, true)
        editor.commit()
    }

    fun checkSession(): Boolean {
        return sp.contains(keyIfLoggedin)
    }

    fun logOutSession(){
        editor.clear().commit()  // delete all data from shared preference file
        //To delete selected data: editor.remove(key)

        val intent = Intent(context, LoginActivity::class.java)
        context.startActivity(intent)
    }

    fun getSessionDetails(key:String):String?{
        return sp.getString(key,null)
    }
}