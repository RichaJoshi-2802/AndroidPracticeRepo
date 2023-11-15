package com.example.sqlitedatabasedemo

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbHelper(context: Context, name:String="demo_db", version:Int=1): SQLiteOpenHelper(context, name, null, version){

    override fun onCreate(db: SQLiteDatabase?) {
        val createTableQuery = "CREATE TABLE register(id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT , email TEXT , password TEXT , gender TEXT)"
        db!!.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP table if exists register")
        onCreate(db)
    }

    fun registerUserHelper(name:String, email:String, password:String, gender:String):Boolean{
        val sqlDb = this.writableDatabase
        val values = ContentValues().also {
            it.put("name",name)
            it.put("email",email)
            it.put("password",password)
            it.put("gender",gender)
        }
        val l= sqlDb.insert("register", null, values)
        sqlDb.close()
        return l>0
    }

    fun login(email:String, password:String): Boolean {
        val sqlDb = this.readableDatabase
        val cursor = sqlDb.rawQuery(
            "select * from register where email='$email' and password = '$password'",
            null
        )
        val loginSuccessful = cursor.moveToFirst()
        cursor.close()
        sqlDb.close()
        return loginSuccessful
    }

    private lateinit var data:UserModal
    fun getLoggedInUserDetails(email:String): UserModal {
        val sqlDb = this.readableDatabase
        val cursor = sqlDb.rawQuery("select * from register where email='$email'",null)
        if(cursor.moveToFirst()){
            data = UserModal(cursor.getString(1), cursor.getString(2), cursor.getString(4))
        }
        cursor.close()
        sqlDb.close()
        return data
    }

    fun updateProfileHelper(name:String, email:String, gender:String): Boolean {
        val sqlDb = this.writableDatabase
        val values = ContentValues().also {
            it.put("name",name)
            it.put("gender",gender)
        }
        val i = sqlDb.update("register",values, "email=?", arrayOf(email))
        sqlDb.close()
        return i>0
    }

    fun deleteProfileHelper(email:String): Boolean {
        val sqlDb = this.writableDatabase
        val i = sqlDb.delete("register", "email=?", arrayOf(email))
        sqlDb.close()
        return i>0
    }

}