package com.example.studentattendance

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import java.text.SimpleDateFormat
import java.util.*

class AttendanceActivity : AppCompatActivity() {
    private lateinit var firestore: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attendance)

        // Initialize Firestore
        firestore = FirebaseFirestore.getInstance()

        val markAttendanceBtn = findViewById<Button>(R.id.markAttendanceBtn)
        markAttendanceBtn.setOnClickListener {
            markAttendance("STU001")  // Pass Student ID
        }
    }

    private fun markAttendance(studentId: String) {
        val timestamp = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Date())

        val attendanceData = hashMapOf(
            "studentId" to studentId,
            "timestamp" to timestamp,
            "verified" to true
        )

        firestore.collection("attendance")
            .add(attendanceData)
            .addOnSuccessListener {
                Log.d("Firestore", "Attendance Marked for $studentId")
            }
            .addOnFailureListener {
                Log.e("Firestore", "Error Marking Attendance: ${it.message}")
            }
    }
}
