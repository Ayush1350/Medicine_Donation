package com.example.MedicineDonationApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
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
            val intent = Intent(this, UploadActivity::class.java)
            startActivity(intent)
        }

//......................................................HISTORY ACTIVITY.......................................................//

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){

                R.id.person -> replaceFragment(ProfileFragment())
                R.id.history -> replaceFragment(HistoryFragment())

                else ->{

                    binding.bottomNavigationView.setOnItemSelectedListener { it

                        when (it.itemId) {
                            R.id.home -> {
                                Intent(this, HomeActivity::class.java).also{ startActivity(it) }
                            }
                        }
                        return@setOnItemSelectedListener true
                    }

                }
            }
            true
        }
    }
    private fun replaceFragment(fragment : Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()



    }
}