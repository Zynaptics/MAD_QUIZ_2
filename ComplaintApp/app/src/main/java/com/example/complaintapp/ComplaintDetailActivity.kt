package com.example.complaintapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class ComplaintDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_complaint_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Get complaint from intent
        val complaint = intent.getSerializableExtra("complaint") as Complaint

        findViewById<TextView>(R.id.tvTitle).text = complaint.title
        findViewById<TextView>(R.id.tvStudentName).text = complaint.studentName
        findViewById<TextView>(R.id.tvRollNumber).text = complaint.rollNumber
        findViewById<TextView>(R.id.tvCategory).text = complaint.category
        findViewById<TextView>(R.id.tvPriority).text = complaint.priority
        findViewById<TextView>(R.id.tvDescription).text = complaint.description
        findViewById<TextView>(R.id.tvStatus).text = complaint.status

        val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault())
        val dateString = dateFormat.format(Date(complaint.timestamp))
        findViewById<TextView>(R.id.tvDate).text = dateString

        findViewById<Button>(R.id.btnBack).setOnClickListener {
            finish()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}