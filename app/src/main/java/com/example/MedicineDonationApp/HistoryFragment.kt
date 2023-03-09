package com.example.MedicineDonationApp

import android.content.ClipData
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.ListResult
import com.google.firebase.storage.StorageReference
class HistoryFragment : Fragment() {

    private lateinit var databaseReference: DatabaseReference
    private lateinit var storageReference: StorageReference
    private lateinit var imageViewFirebase: ImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_history, container, false)
        init(view)
        getImagesFromFirebase()
        return view
    }

    private fun init(view: View) {
        databaseReference = FirebaseDatabase.getInstance().reference
        storageReference = FirebaseStorage.getInstance().reference
        imageViewFirebase = view.findViewById(R.id.imageView)
    }

    private fun getImagesFromFirebase() {

        val imageRef = storageReference.child("Donatae Medicine Images")
        imageRef.listAll()
            .addOnSuccessListener {
                // Get the list of items
                it.items.forEach { item ->
                    item.downloadUrl
                        .addOnSuccessListener {
                            // Do something with download URL
                            Glide.with(imageViewFirebase)
                                .load(it)
                                .into(imageViewFirebase)
                        }
                }
            }
            .addOnFailureListener {
                // Uh-oh, an error occurred!
            }
    }
}

