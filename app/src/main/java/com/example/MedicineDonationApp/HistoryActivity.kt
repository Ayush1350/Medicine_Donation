package com.example.MedicineDonationApp

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.MedicineDonationApp.databinding.ActivityHistoryBinding
import com.example.MedicineDonationApp.databinding.ActivityLoginBinding
import com.example.MedicineDonationApp.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference


class HistoryActivity: AppCompatActivity() {

    private lateinit var binding: ActivityHistoryBinding
    private lateinit var firebaseAuth: FirebaseAuth



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()

        val GetImages = findViewById<Button>(R.id.GetImages)


        GetImages.setOnClickListener {
            val db = FirebaseFirestore.getInstance()
            val imagesRef = db.collection("Donatae Medicine Images")

            imagesRef.get().addOnSuccessListener { result ->
                for (document in result) {
                    val imageUrl = document.data["https://medicine-donation-90ae2-default-rtdb.firebaseio.com/Donation%20List"] as String
                    val imageView = ImageView(this)
                    Glide.with(this).load(imageUrl).into(imageView)
                }
            }
        }
    }
}
