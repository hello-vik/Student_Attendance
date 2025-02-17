package com.example.studentattendance

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AdminPanelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_panel)

        val registerStudentBtn = findViewById<Button>(R.id.registerStudentBtn)

        registerStudentBtn.setOnClickListener {
            startActivity(Intent(this, RegisterStudentActivity::class.java))
        }
    }
}
