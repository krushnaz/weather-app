plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.hilt)    // 👈 apply here
    kotlin("kapt")
    alias(libs.plugins.compose.compiler)

// still add kapt manually
}

android {
    namespace = "com.krushna.weather"
    compileSdk = 36

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.composeCompiler.get()
    }

    defaultConfig {
        applicationId = "com.krushna.weather"
        minSdk = 24
        targetSdk = 36
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

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation("androidx.activity:activity-compose:1.9.0")
    implementation("androidx.compose.ui:ui:1.6.3")
    implementation("androidx.compose.material3:material3:1.2.1")
    implementation("androidx.compose.ui:ui-tooling-preview:1.6.3")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.0")
    implementation("androidx.navigation:navigation-compose:2.8.0")
    implementation("androidx.compose.runtime:runtime-livedata:1.6.3")
    implementation("com.google.dagger:hilt-android:2.51")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")
    kapt("com.google.dagger:hilt-android-compiler:2.51")
    implementation("com.google.android.material:material:1.12.0")
//    implementation(libs.compose.compiler)

    // Lottie animation
    implementation ("com.airbnb.android:lottie-compose:6.3.0")

    // Jetpack Compose (your existing ones)
    implementation("androidx.activity:activity-compose:1.9.0")
    implementation("androidx.compose.ui:ui:1.6.3")
    implementation("androidx.compose.material3:material3:1.2.1")
    implementation("androidx.compose.ui:ui-tooling-preview:1.6.3")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.0")
    implementation("androidx.navigation:navigation-compose:2.8.0")
    implementation("androidx.compose.runtime:runtime-livedata:1.6.3")
    implementation("androidx.compose.material:material-icons-extended:1.6.3")

    implementation("io.coil-kt:coil-compose:2.4.0")
// for background image
    implementation("com.airbnb.android:lottie-compose:6.0.0")
// for optional animations
}

