package com.example.complaintapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ComplaintAdapter(
    private val complaints: List<Complaint>,
    private val onItemClick: (Complaint) -> Unit
) : RecyclerView.Adapter<ComplaintAdapter.ComplaintViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComplaintViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_complaint, parent, false)
        return ComplaintViewHolder(view)
    }

    override fun onBindViewHolder(holder: ComplaintViewHolder, position: Int) {
        val complaint = complaints[position]
        holder.bind(complaint)
        holder.itemView.setOnClickListener { onItemClick(complaint) }
    }

    override fun getItemCount() = complaints.size

    class ComplaintViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        private val tvStudentName: TextView = itemView.findViewById(R.id.tvStudentName)
        private val tvRollNumber: TextView = itemView.findViewById(R.id.tvRollNumber)
        private val tvCategory: TextView = itemView.findViewById(R.id.tvCategory)
        private val tvPriority: TextView = itemView.findViewById(R.id.tvPriority)

        fun bind(complaint: Complaint) {
            tvTitle.text = complaint.title
            tvStudentName.text = "Name: ${complaint.studentName}"
            tvRollNumber.text = "Roll: ${complaint.rollNumber}"
            tvCategory.text = complaint.category
            tvPriority.text = complaint.priority

            // Set priority color
            when {
                complaint.priority.contains("Urgent") -> tvPriority.setBackgroundColor(
                    itemView.context.getColor(android.R.color.holo_red_light))
                complaint.priority.contains("High") -> tvPriority.setBackgroundColor(
                    itemView.context.getColor(android.R.color.holo_orange_light))
                complaint.priority.contains("Medium") -> tvPriority.setBackgroundColor(
                    itemView.context.getColor(android.R.color.holo_blue_light))
                else -> tvPriority.setBackgroundColor(
                    itemView.context.getColor(android.R.color.holo_green_light))
            }
        }
    }
}