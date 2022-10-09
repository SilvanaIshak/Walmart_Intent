package com.example.walmart_intent

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_create_account.*

class CreateAccount : AppCompatActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        btnCreateAcc.setOnClickListener{
         var regUser = User(txtEmailaddress.text.toString(),txtPassword.text.toString(),txtFname.text.toString(),
             txtLastName.text.toString())
            Toast.makeText(this, "Account created successfully!",Toast.LENGTH_LONG).show()
            Intent(this, MainActivity::class.java).also{
                it.putExtra("regUser", regUser)
                startActivity(it)
            }
        }
    }
}