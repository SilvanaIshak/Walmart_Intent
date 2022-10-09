package com.example.walmart_intent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val userarray = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        var userarray = arrayListOf<User>(User("Vana", "123", "Vana", "Ishak"),
//            User("Sara", "123", "Sara", "Sami"),
//            User("Andy", "123", "Andy", "Ishak"),
//            User("Eddie", "123", "Eddie", "Ishak"))


        userarray.add(User("Vana", "123", "Vana", "Ishak"))
        userarray.add(User("Sara", "123", "Sara", "Sami"))
        userarray.add(User("Andy", "123", "Andy", "Ishak"))
        userarray.add(User("Eddie", "123", "Eddie", "Ishak"))
        userarray.add(User("user1", "123", "user1", "user1"))

//        val user = intent.getSerializableExtra("User") as User
        btnCreate.setOnClickListener {
            Intent(this, CreateAccount::class.java).also {
                startActivity(it)
            }
        }

        val txtPassForgot : TextView = findViewById(R.id.txtForgot)
        txtPassForgot.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("http://www.walmart.com/account/forgotpassword")
            startActivity(openURL)
        }

        btnSignIn.setOnClickListener {
            var email= txtEmail.text.toString()
            var password= txtPass.text.toString()
            var loggedInUser: User? = null
            for (user in userarray)
            {
                if ((email == user.username) && (password == user.password) )
                {
                    loggedInUser = user
                    break
                }
            }
            if (loggedInUser == null) {
                Toast.makeText(this, "User not recognized", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            Toast.makeText(this,"Welcome ${loggedInUser.firstName} ${loggedInUser.lastName}", Toast.LENGTH_LONG).show()
            var newPage = Intent(this, Shop::class.java)
            newPage.putExtra("flname", "Welcome ${loggedInUser.firstName} ${loggedInUser.lastName}")
            startActivity(newPage)
        }




    }

    override fun onResume() {
        super.onResume()

        val rintent = intent.getSerializableExtra("regUser") as User?
        if (rintent != null) {
            userarray.add(rintent)
        }
    }
}
