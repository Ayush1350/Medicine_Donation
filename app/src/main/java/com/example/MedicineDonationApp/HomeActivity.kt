package com.example.MedicineDonationApp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.MedicineDonationApp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    lateinit var viewPager: ViewPager
    lateinit var viewPagerAdapter: ViewPagerAdapter
    lateinit var imageList: List<Int>
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

//......................................................IMAGE SLIDER.......................................................//

        viewPager = findViewById(R.id.idViewPager)
        imageList = ArrayList<Int>()
        imageList = imageList + R.drawable.img
        imageList = imageList + R.drawable.img_1
        viewPagerAdapter = ViewPagerAdapter(this@HomeActivity, imageList)
        viewPager.adapter = viewPagerAdapter

//......................................................UPLOAD ACTIVITY.......................................................//

        binding.Donate.setOnClickListener {
            val intent = Intent (this,UploadActivity::class.java)
            startActivity(intent)
        }

//......................................................HISTORY ACTIVITY.......................................................//

        binding.bottomNavigationView.selectedItemId = R.id.history
        binding.bottomNavigationView.setOnItemSelectedListener {it
            when (it.itemId) {
                R.id.history -> {
                    Intent(this, HistoryActivity::class.java).also{ startActivity(it) }
                }
            }
            return@setOnItemSelectedListener true
        }
//......................................................LOCATION ACTIVITY.......................................................//

        binding.bottomNavigationView.selectedItemId = R.id.location
        binding.bottomNavigationView.setOnItemSelectedListener {it
            when (it.itemId) {
                R.id.location -> {
                    val gmmIntentUri = Uri.parse("geo:0,0?q=NGO near me")
                    val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                    mapIntent.setPackage("com.google.android.apps.maps")
                    startActivity(mapIntent)
                }
            }
            return@setOnItemSelectedListener true

        }

    }

}