package com.example.signupandsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.detils.*

class UserDetils : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detils)

        val userName = intent.getStringExtra("UserName")
        val userLoc = intent.getStringExtra("UserLoc")
        val userEamil = intent.getStringExtra("UserEmail")
        val userPsd = intent.getStringExtra("UserPsd")



        textView.text = "WELLCOME $userName"
        textName.text = "Name : $userName"
        textLoc.text = "Location : $userLoc"
        textEmail.text = "Email : $userEamil"
        textPass.text = "Password : $userPsd"

        btn_logout.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }
}