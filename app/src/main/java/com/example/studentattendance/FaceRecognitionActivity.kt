//package com.example.studentattendance
//
//import android.graphics.Bitmap
//import android.os.Bundle
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//import com.example.studentattendance.utils.FirebaseUtils
//import com.google.mlkit.vision.common.InputImage
//import com.google.mlkit.vision.face.FaceDetection
//import com.google.mlkit.vision.face.FaceDetectorOptions
//
//class FaceRecognitionActivity : AppCompatActivity() {
//    private lateinit var bitmap: Bitmap  // 🔥 FIXED: Bitmap should be initialized later
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_face_recognition)
//
//        // TODO: Implement camera capture and assign image to 'bitmap'
//        // bitmap = GetBitmapFromCamera() (Implement CameraX or Camera API)
//
//        detectFaceAndMarkAttendance(bitmap)
//    }
//
//    private fun detectFaceAndMarkAttendance(bitmap: Bitmap) {
//        val image = InputImage.fromBitmap(bitmap, 0)
//
//        val options = FaceDetectorOptions.Builder()
//            .setPerformanceMode(FaceDetectorOptions.PERFORMANCE_MODE_ACCURATE)
//            .setMinFaceSize(0.15f)
//            .enableTracking() // Enables face ID tracking
//            .build()
//
//        val detector = FaceDetection.getClient(options)
//
//        detector.process(image)
//            .addOnSuccessListener { faces ->
//                if (faces.isNotEmpty()) {
//                    val studentId = "STUDENT123" // TODO: Implement actual Face ID matching logic
//                    markAttendance(studentId)
//                } else {
//                    Toast.makeText(this, "No face detected!", Toast.LENGTH_SHORT).show()
//                }
//            }
//            .addOnFailureListener { e ->
//                Toast.makeText(this, "Face Detection Failed: ${e.message}", Toast.LENGTH_SHORT).show()
//            }
//    }
//
//    private fun markAttendance(studentId: String) {
//        val attendanceRecord = hashMapOf(
//            "studentId" to studentId,
//            "timestamp" to System.currentTimeMillis()
//        )
//
//        FirebaseUtils.firestore.collection("attendance")
//            .add(attendanceRecord)
//            .addOnSuccessListener {
//                Toast.makeText(this, "Attendance Marked!", Toast.LENGTH_SHORT).show()
//            }
//            .addOnFailureListener {
//                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show()
//            }
//    }
//}
