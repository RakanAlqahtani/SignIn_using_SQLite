package com.example.signupandsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.singup.*

class SingUp : AppCompatActivity() {
    private val databaseHelper by lazy { MyDBHelper(applicationContext) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.singup)

        btn_singup.setOnClickListener {
            if (username.text.isNotEmpty() && loc.text.isNotEmpty() && email.text.isNotEmpty() && password.text.isNotEmpty()) {
                var userInfo = UserModel(
                    username.text.toString(),
                    loc.text.toString(),
                    email.text.toString(),
                    password.text.toString()
                )
                databaseHelper.addUser(userInfo)
                val intent = Intent(this, UserDetils::class.java)
                intent.putExtra("UserName", username.text.toString())
                intent.putExtra("UserLoc", loc.text.toString())
                intent.putExtra("UserEmail", email.text.toString())
                intent.putExtra("UserPsd", password.text.toString())
                startActivity(intent)

            } else {

                    Toast.makeText(this,"Pleas fill all the text",Toast.LENGTH_LONG).show()
            }
        }

    }
}