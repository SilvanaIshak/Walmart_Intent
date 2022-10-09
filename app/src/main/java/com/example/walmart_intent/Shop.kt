package com.example.walmart_intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_shop.*
import kotlinx.android.synthetic.main.activity_shop.view.*

class Shop : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)

        val rintent = intent
        var welcometxt = rintent.getStringExtra("flname")
        lblwelcome.text = welcometxt

        tv.setOnClickListener(){
            Toast.makeText(this, "You have chosen the ELECTRONIC category of shopping", Toast.LENGTH_LONG).show()
        }

        jacket.setOnClickListener() {
            Toast.makeText(this, "You have chosen the CLOTHING category of shopping", Toast.LENGTH_LONG).show()
        }

        beauty.setOnClickListener(){
            Toast.makeText(this, "You have chosen the BEAUTY category of shopping", Toast.LENGTH_LONG).show()
        }

        pasta.setOnClickListener(){
            Toast.makeText(this, "You have chosen the FOOD category of shopping", Toast.LENGTH_LONG).show()
        }


    }
}