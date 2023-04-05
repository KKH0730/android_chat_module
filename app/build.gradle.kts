plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("com.google.gms.google-services")
}

android {
    compileSdk = 32

    defaultConfig {
        applicationId = "android.chat.example"
        minSdk = 21
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }

        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.2.0"
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
        compose = true
    }
}

dependencies {

    //AndroidX
    implementation(Dependency.AndroidX.APP_COMPAT)
    implementation(Dependency.AndroidX.MATERIAL)
    implementation(Dependency.AndroidX.CONSTRAINT_LAYOUT)
    implementation(Dependency.AndroidX.ACTIVITY_KTX)
    implementation(Dependency.AndroidX.FRAGMENT_KTX)

    //Firebase
    implementation(platform(Dependency.Firebase.FIREBASE_BOM))
    implementation(Dependency.Firebase.REALTIME_DATABASE)

    //KTX
    implementation(Dependency.KTX.CORE)

    // Compose
    implementation(Dependency.Compose.ACTIVITY_COMPOSE)
    implementation(Dependency.Compose.MATERIAL)
    implementation(Dependency.Compose.RUNTIME)
    implementation(Dependency.Compose.UI)
    debugImplementation(Dependency.Compose.UI_TOOLING)
    implementation(Dependency.Compose.PREVIEW)
    implementation(Dependency.Hilt.HILT_NAVIGATION)
    implementation(Dependency.Lifecycle.VIEWMODEL_COMPOSE)
    implementation(Dependency.Lifecycle.RUNTIME_COMPOSE)
    implementation(Dependency.Paging.COMPOSE)
    implementation(Dependency.Compose.COMPOSE_CONSTRAINT)
    implementation(Dependency.Compose.NAVIGATION)

    // Retrofit
    implementation(Dependency.Retrofit.RETROFIT)
    implementation(Dependency.Retrofit.GSON_CONVERTER)
    implementation(Dependency.OkHttp.LOGGING_INTERCEPTOR)

    // ETC
    implementation(Dependency.Etc.TIMBER)
    implementation(Dependency.Etc.GSON)


    //TEST
    testImplementation(Dependency.Test.JUNIT)
    androidTestImplementation(Dependency.AndroidTest.TEST_RUNNER)
    androidTestImplementation(Dependency.AndroidTest.ESPRESSO_CORE)

    // Hilt
    implementation(Dependency.Hilt.ANDROID)
    kapt(Dependency.Hilt.COMPILER)
    testImplementation(Dependency.Hilt.TESTING)
}