package com.example.MedicineDonationApp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class OptionActivity : AppCompatActivity() {

    private lateinit var binding: OptionActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_option)

        val Donor = findViewById<Button>(R.id.bwt_donor)
        val Ngo = findViewById<Button>(R.id.bwt_ngo)

        Donor.setOnClickListener {
            val intent = Intent (this, LoginActivity::class.java)
            startActivity(intent)
        }
        Ngo.setOnClickListener {
            val intent = Intent (this , HomeNActivity::class.java)
            startActivity(intent)
        }
    }
}