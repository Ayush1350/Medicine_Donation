package com.example.MedicineDonationApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.MedicineDonationApp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.Donate.setOnClickListener {
            val intent = Intent (this,UploadActivity::class.java)
            startActivity(intent)
        }

        binding.bottomNavigationView.selectedItemId = R.id.history
        binding.bottomNavigationView.setOnItemSelectedListener {it
            when (it.itemId) {
                R.id.history -> {
                    Intent(this, HistoryActivity::class.java).also{ startActivity(it) }
                }
            }
            return@setOnItemSelectedListener true

        }

    }

}