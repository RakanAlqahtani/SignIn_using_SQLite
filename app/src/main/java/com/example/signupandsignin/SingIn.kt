package com.example.signupandsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.singin.*
import kotlinx.android.synthetic.main.singup.*

class SingIn : AppCompatActivity() {
    private val databaseHelper by lazy { MyDBHelper(applicationContext) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.singin)

        btn_login.setOnClickListener {
            if (et_userName.text.isNotEmpty() && et_password.text.isNotEmpty()) {

                if (databaseHelper.checkUser(et_userName.text.toString(),et_password.text.toString())){

                    val userInfo = databaseHelper.getDate(et_userName.text.toString())

                    val intent = Intent(this, UserDetils::class.java)
                    intent.putExtra("UserName", et_userName.text.toString())
                    intent.putExtra("UserPsd", et_password.text.toString())
                    intent.putExtra("UserLoc", userInfo[0].toString())
                    intent.putExtra("UserEmail", userInfo[1].toString())
                    startActivity(intent)
                }else {

                    Toast.makeText(this, "The user Name or password wrong", Toast.LENGTH_LONG)
                        .show()

                }
            }
        }


    }
}