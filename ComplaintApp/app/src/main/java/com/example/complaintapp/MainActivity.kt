package com.example.complaintapp

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.FirebaseRRFFFFFYBU

class MainActivity : AppCompatActivity() {

    private lateinit var etStudentName: EditText
    private lateinit var etRollNumber: EditText
    private lateinit var etTitle: EditText
    private lateinit var spinnerCategory: Spinner
    private lateinit var spinnerPriority: Spinner
    private lateinit var etDescription: EditText
    private lateinit var btnSubmit: Button
    private lateinit var btnViewComplaints: Button
    private lateinit var tvMessage: TextView

    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize Firebase
        db = Firebase.firestore

        // Initialize views
        etStudentName = findViewById(R.id.etStudentName)
        etRollNumber = findViewById(R.id.etRollNumber)
        etTitle = findViewById(R.id.etTitle)
        spinnerCategory = findViewById(R.id.spinnerCategory)
        spinnerPriority = findViewById(R.id.spinnerPriority)
        etDescription = findViewById(R.id.etDescription)
        btnSubmit = findViewById(R.id.btnSubmit)
        btnViewComplaints = findViewById(R.id.btnViewComplaints)
        tvMessage = findViewById(R.id.tvMessage)

        // Submit button click
        btnSubmit.setOnClickListener { submitComplaint() }

        // View complaints button click
        btnViewComplaints.setOnClickListener {
            startActivity(android.content.Intent(this, ComplaintListActivity::class.java))
        }
    }

    private fun submitComplaint() {
        val studentName = etStudentName.text.toString().trim()
        val rollNumber = etRollNumber.text.toString().trim()
        val title = etTitle.text.toString().trim()
        val category = spinnerCategory.selectedItem.toString()
        val priority = spinnerPriority.selectedItem.toString()
        val description = etDescription.text.toString().trim()

        // Validate all fields
        if (studentName.isEmpty() || rollNumber.isEmpty() || title.isEmpty() || description.isEmpty()) {
            tvMessage.text = getString(R.string.validation_error)
            tvMessage.setTextColor(android.graphics.Color.RED)
            return
        }

        // Create complaint object
        val complaint = hashMapOf(
            "studentName" to studentName,
            "rollNumber" to rollNumber,
            "title" to title,
            "category" to category,
            "priority" to priority,
            "description" to description,
            "status" to "Pending",
            "timestamp" to System.currentTimeMillis()
        )

        // Save to Firebase
        db.collection("complaints")
            .add(complaint)
            .addOnSuccessListener {
                tvMessage.text = getString(R.string.submit_success)
                tvMessage.setTextColor(android.graphics.Color.GREEN)
                clearForm()
            }
            .addOnFailureListener {
                tvMessage.text = getString(R.string.submit_failed)
                tvMessage.setTextColor(android.graphics.Color.RED)
            }
    }

    private fun clearForm() {
        etStudentName.text.clear()
        etRollNumber.text.clear()
        etTitle.text.clear()
        spinnerCategory.setSelection(0)
        spinnerPriority.setSelection(0)
        etDescription.text.clear()
    }
}