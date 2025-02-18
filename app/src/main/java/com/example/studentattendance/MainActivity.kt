package com.example.studentattendance

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import android.widget.Button
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
//hello
//world
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val takeAttendanceBtn = findViewById<Button>(R.id.takeAttendanceBtn)
        val adminPanelBtn = findViewById<Button>(R.id.adminPanelBtn)

        takeAttendanceBtn.setOnClickListener {
            startActivity(Intent(this, FaceRecognitionActivity::class.java))
        }

        adminPanelBtn.setOnClickListener {
            startActivity(Intent(this, AdminPanelActivity::class.java))
        }

//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
        }
    }
