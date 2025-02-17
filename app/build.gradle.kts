plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.google.gms.google.services)
}

android {
    namespace = "com.example.studentattendance"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.studentattendance"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    buildFeatures {
        viewBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.firebase.auth)
    implementation(libs.firebase.firestore.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

        // ML Kit Face Detection (Latest version)
        implementation("com.google.mlkit:face-detection:16.1.5")

        // Firebase Firestore (Ensure it's also included)
        implementation("com.google.firebase:firebase-storage-ktx:24.5.0")


//        implementation(com.google.firebase:firebase-auth-ktx)
//        implementation(com.google.firebase:firebase-firestore-ktx)
//        implementation(com.google.firebase:firebase-storage-ktx)
//        implementation(com.google.mlkit:face-detection:16.1.5)
}