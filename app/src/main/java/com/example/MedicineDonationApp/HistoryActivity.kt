package com.example.MedicineDonationApp

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference


class HistoryActivity: AppCompatActivity() {
    var imagelist: ArrayList<String>? = null
    var recyclerView: RecyclerView? = null
    var root: StorageReference? = null
    var progressBar: ProgressBar? = null
    var adapter: ImageAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        imagelist = ArrayList()
        recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        adapter = ImageAdapter(imagelist!!, this)
        recyclerView?.setLayoutManager(LinearLayoutManager(null))
        progressBar = findViewById<ProgressBar>(R.id.progress)
        progressBar?.setVisibility(View.VISIBLE)
        val listRef = FirebaseStorage.getInstance().reference.child("images")
        listRef.listAll().addOnSuccessListener { listResult ->
            for (file in listResult.items) {
                file.downloadUrl.addOnSuccessListener { uri ->
                    imagelist!!.add(uri.toString())
                    Log.e("Itemvalue", uri.toString())
                }.addOnSuccessListener {
                    recyclerView?.setAdapter(adapter)
                    progressBar?.setVisibility(View.GONE)
                }
            }
        }
    }
}
