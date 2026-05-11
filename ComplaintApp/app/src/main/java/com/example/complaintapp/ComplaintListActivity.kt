package com.example.complaintapp

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class ComplaintListActivity : AppCompatActivity() {

    private lateinit var rvComplaints: RecyclerView
    private lateinit var tvEmpty: TextView
    private lateinit var db: FirebaseFirestore
    private lateinit var adapter: ComplaintAdapter
    private val complaintsList = mutableListOf<Complaint>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_complaint_list)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = "Complaints"

        db = Firebase.firestore

        rvComplaints = findViewById(R.id.rvComplaints)
        tvEmpty = findViewById(R.id.tvEmpty)

        rvComplaints.layoutManager = LinearLayoutManager(this)
        adapter = ComplaintAdapter(complaintsList) { complaint ->
            val intent = Intent(this, ComplaintDetailActivity::class.java)
           // intent.putExtra("complaint", complaint)
            intent.putExtra("complaint", complaint as java.io.Serializable)
            startActivity(intent)
        }
        rvComplaints.adapter = adapter

        loadComplaints()
    }

    private fun loadComplaints() {
        db.collection("complaints")
            .orderBy("timestamp", com.google.firebase.firestore.Query.Direction.DESCENDING)
            .get()
            .addOnSuccessListener { result ->
                complaintsList.clear()
                for (document in result) {
                    val complaint = Complaint(
                        id = document.id,
                        studentName = document.getString("studentName").orEmpty(),
                        rollNumber = document.getString("rollNumber").orEmpty(),
                        title = document.getString("title").orEmpty(),
                        category = document.getString("category").orEmpty(),
                        priority = document.getString("priority").orEmpty(),
                        description = document.getString("description").orEmpty(),
                        status = document.getString("status").orEmpty(),
                        timestamp = document.getLong("timestamp") ?: 0
                    )
                    complaintsList.add(complaint)
                }
                adapter.notifyDataSetChanged()

                if (complaintsList.isEmpty()) {
                    tvEmpty.visibility = android.view.View.VISIBLE
                    rvComplaints.visibility = android.view.View.GONE
                } else {
                    tvEmpty.visibility = android.view.View.GONE
                    rvComplaints.visibility = android.view.View.VISIBLE
                }
            }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}