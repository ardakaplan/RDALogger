plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {

    namespace = "com.ardakaplan.testapp.rdalogger"
    compileSdk = 35

    defaultConfig {

        applicationId = "com.ardakaplan.testapp.rdalogger"

        minSdk = 21
        targetSdk = 35

        versionCode = 1
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {

        release {

            isMinifyEnabled = false

            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {

        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions { jvmTarget = "11" }

}

dependencies {

    implementation(libs.androidx.appcompat)

    //    RDA LIB
    implementation(project(":RDALogger"))
}