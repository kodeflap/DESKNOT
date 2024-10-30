plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    kotlin("kapt")
    alias(libs.plugins.androidx.navigation.safe.args)
    id("kotlin-parcelize")
    alias(libs.plugins.google.dagger.hilt)
}

android {
    namespace = "com.kodeflap.desknot"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.kodeflap.desknot"
        minSdk = 24
        targetSdk = 34
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
    sourceSets {
        getByName("main") {
            kotlin {
                // Add the correct path for generated navigation arguments
                srcDirs("build/generated/source/navigation-args/")
            }
        }
    }

    buildFeatures {
        dataBinding = true
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
    implementation(libs.androidx.navigation.fragment)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation("androidx.databinding:databinding-runtime:8.7.1")

    //Material Components
    implementation(libs.material)

    // RecyclerView Animator
    implementation("jp.wasabeef:recyclerview-animators:4.0.2")

    // Navigation Component
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation("android.arch.navigation:navigation-fragment-ktx:1.0.0")

    // Lifecycle components
    implementation(libs.androidx.lifecycle.extensions)
    implementation(libs.androidx.lifecycle.common.java8)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)


    // Room dependencies
    implementation(libs.androidx.room.runtime)
    kapt(libs.androidx.room.compiler)
    implementation(libs.androidx.room.ktx)

    // Recyclerview
    implementation(libs.androidx.recyclerview)

    // Kotlin components
    api(libs.kotlinx.coroutines.core)
    api(libs.kotlinx.coroutines.android)

    // DataBinding
    kapt(libs.compiler)
    kapt(libs.androidx.databinding.common)

    //hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)
}
kapt {
    correctErrorTypes = true
}
