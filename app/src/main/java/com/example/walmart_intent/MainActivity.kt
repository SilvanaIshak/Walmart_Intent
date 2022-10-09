package com.example.walmart_intent

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val userarray = ArrayList<User>()

    @SuppressLint("QueryPermissionsNeeded")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userarray.add(User("Vana", "1234", "Vana", "Ishak"))
        userarray.add(User("Sara", "123", "Sara", "Sami"))
        userarray.add(User("Andy", "123", "Andy", "Ishak"))
        userarray.add(User("Eddie", "123", "Eddie", "Ishak"))
        userarray.add(User("user1", "123", "user1", "user1"))

        btnCreate.setOnClickListener {
            Intent(this, CreateAccount::class.java).also {
                startActivity(it)
            }
        }

        val txtPassForgot : TextView = findViewById(R.id.txtForgot)
        txtPassForgot.setOnClickListener {
            if (txtEmail.text.toString().isNotEmpty()) {
                var intent = Intent(Intent.ACTION_SENDTO)
                intent.data = Uri.parse("mailto:") // only email apps should handle this
                var sendto = arrayOf(txtEmail.text.toString() + "@gmail.com")
                intent.putExtra(Intent.EXTRA_EMAIL, sendto);
                intent.putExtra(Intent.EXTRA_SUBJECT, "Password Request");
                intent.putExtra(Intent.EXTRA_TEXT, "Your password is: ${userarray.find { it.username == txtEmail.text.toString() }?.password}");
                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(intent);
                }
            }
            else {
                Toast.makeText(this, "Please enter your email address", Toast.LENGTH_LONG).show()
            }
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
