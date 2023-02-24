package com.example.MedicineDonationApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
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
        loadFragment(HomeFragment())


//......................................................LOCATION ACTIVITY.......................................................//




//......................................................BOTTOM NAVIGATION.......................................................//


        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.home -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.person -> {
                    loadFragment(ProfileFragment())
                    true
                }
                R.id.history -> {
                    loadFragment(HistoryFragment())
                    true
                }
                R.id.location -> {
                    loadFragment(LocationFragment())
                    true
                }

                else-> {
                    false
                }
            }
        }
    }
    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_layout,fragment)
        transaction.commit()
    }

}
