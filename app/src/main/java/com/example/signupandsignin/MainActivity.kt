package com.example.signupandsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sing_in.setOnClickListener {
            val intent = Intent(this,SingIn::class.java)

            startActivity(intent)
        }

        sing_up.setOnClickListener {
            val intent = Intent(this,SingUp::class.java)
            startActivity(intent)

        }
    }
}