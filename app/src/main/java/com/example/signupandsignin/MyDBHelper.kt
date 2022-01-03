package com.example.signupandsignin

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDBHelper(context: Context) :SQLiteOpenHelper(context,"USERDB",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE USERS(USERID INTEGER PRIMARY KEY AUTOINCREMENT ,NAME TEXT,LOCATION TEXT,EMAIL TEXT,PWD TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("drop table if EXISTS USERS")
        onCreate(db)
    }

    fun addUser(User : UserModel){
        var db = writableDatabase
        val contentValues  = ContentValues()
        contentValues.put("NAME",User.userName)
        contentValues.put("LOCATION",User.userLocation)
        contentValues.put("EMAIL",User.userEmail)
        contentValues.put("PWD",User.userPassword)
        db.insert("USERS",null,contentValues)

    }

    fun checkUser(userName : String , pwd : String): Boolean{
        var db = writableDatabase
        val args = listOf<String>(userName,pwd).toTypedArray()
        val cursor : Cursor = db.rawQuery("SELECT * FROM USERS WHERE NAME = ? and PWD = ?",args)
        if(cursor.moveToNext()){
            return true

        }else
            return false
    }

    fun getDate(userName : String ): ArrayList<String> {


        val userInfo = arrayListOf<String>()
        val args = listOf<String>(userName).toTypedArray()

        // read all data using cursor
        var db = writableDatabase

        val cursor : Cursor = db.rawQuery("SELECT * FROM USERS WHERE NAME = ? ",args)

        if (cursor.count < 1) {
            println("No data Found")
            return userInfo
        } else {
           cursor.moveToFirst()
                val loc = cursor.getString(cursor.getColumnIndex("LOCATION"))  // The integer value refers to the column
                val email = cursor.getString(cursor.getColumnIndex("EMAIL"))
            userInfo.add(loc)
            userInfo.add(email)

        }



        return userInfo

    }

}
