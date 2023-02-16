package com.example.MedicineDonationApp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.MedicineDonationApp.databinding.ActivityHistoryBinding
import com.example.MedicineDonationApp.databinding.ActivityHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var bottomNavigation: BottomNavigationView
    lateinit var viewPager: ViewPager
    lateinit var viewPagerAdapter: ViewPagerAdapter
    lateinit var imageList: List<Int>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//...............................................IMAGE SLIDER........................................................//

        viewPager = findViewById(R.id.idViewPager)
        imageList = ArrayList<Int>()
        imageList = imageList + R.drawable.img
        imageList = imageList + R.drawable.img_1
        imageList = imageList + R.drawable.img_2
        imageList = imageList + R.drawable.img_3
        viewPagerAdapter = ViewPagerAdapter(this@HomeActivity, imageList)
        viewPager.adapter = viewPagerAdapter

//...............................................UPLOAD ACTIVITY........................................................//

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.Donate.setOnClickListener {
            val intent = Intent (this,UploadActivity::class.java)
            startActivity(intent)
        }

//...............................................HISTORY ACTIVITY........................................................//

        binding.bottomNavigationView.selectedItemId = R.id.home
        binding.bottomNavigationView.selectedItemId = R.id.location
        binding.bottomNavigationView.selectedItemId = R.id.person
        binding.bottomNavigationView.setOnItemSelectedListener { it ->
            when (it.itemId) {
                R.id.history -> {
                    Intent(this, HistoryActivity::class.java).also {
                        startActivity(it) }
                }
            }
            return@setOnItemSelectedListener true
        }


//...............................................LOCATION ACTIVITY........................................................//

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