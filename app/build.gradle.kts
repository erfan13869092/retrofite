@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    libs.apply {
        alias(plugins.androidApplication)
        alias(plugins.kotlinAndroid)
        alias(plugins.ksp)
        alias(plugins.hilt.plugin)
    }
}

android {
    namespace = "com.example.apiretrofite"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.apiretrofite"
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    libs.apply {
        implementation(core.ktx)
        implementation(appcompat)
        implementation(material)
        implementation(constraintlayout)
        testImplementation(junit)
        androidTestImplementation(androidx.test.ext.junit)
        androidTestImplementation(espresso.core)
        implementation(bundles.newtwork)
        implementation(bundles.navigation)
        implementation(libs.hilt.android)
        ksp(libs.hilt.kapt)
    }
}