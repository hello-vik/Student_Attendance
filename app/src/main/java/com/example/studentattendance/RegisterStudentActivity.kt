package com.example.studentattendance


import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.studentattendance.utils.FirebaseUtils

class RegisterStudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_student)

        val studentIdInput = findViewById<EditText>(R.id.studentIdInput)
        val studentNameInput = findViewById<EditText>(R.id.studentNameInput)
        val registerStudentBtn = findViewById<Button>(R.id.registerStudentBtn)

        registerStudentBtn.setOnClickListener {
            val studentId = studentIdInput.text.toString().trim()
            val studentName = studentNameInput.text.toString().trim()

            val studentData = hashMapOf(
                "studentId" to studentId,
                "name" to studentName,
                "faceIdUrl" to ""
            )

            FirebaseUtils.firestore.collection("students")
                .document(studentId)
                .set(studentData)
                .addOnSuccessListener {
                    Toast.makeText(this, "Student Registered!", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener {
                    Log.e("Firestore", "Error Registering Student: ${it.message}")
                }
        }
    }
}
