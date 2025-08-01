import java.util.regex.Pattern.compile

plugins {
    id("com.android.application") version "8.10.0"
//    id("org.jetbrains.kotlin.android") version "2.2.0" apply false
//    id("org.jetbrains.kotlin.kapt")

    id("com.google.gms.google-services") version "4.4.3"
    id("kotlin-parcelize")
    id("com.google.devtools.ksp")

//    id("org.jetbrains.kotlin.kapt")

//    alias(libs.plugins.kotlinKapt)
//    id("org.jetbrains.kotlin.kapt") version "2.2.0"
//    id("org.jetbrains.kotlin.kapt") version "2.2.0"

//    alias(libs.plugins.compose.compiler)
//    id("org.jetbrains.kotlin.kapt") version "2.2.0"
//    id("org.jetbrains.kotlin.kapt") version "2.2.0"
}

android {
    namespace = "com.example.appkkweather"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.appkkweather"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        externalNativeBuild {
            cmake {
                cppFlags += ""
            }
        }
    }

    buildFeatures {
        viewBinding = true
        dataBinding = true
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.0"
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

    externalNativeBuild {
        cmake {
            path = file("src/main/cpp/CMakeLists.txt")
            version = "3.22.1"
        }
    }
}

dependencies {
    implementation("androidx.compose.material:material:1.8.3")
    implementation("androidx.compose.foundation:foundation-layout-android:1.8.3")
//    kapt("com.android.databinding:compiler:8.10.0")
//    kapt("com.google.dagger:hilt-android-compiler:VERSION")
//
    implementation("androidx.datastore:datastore-preferences:1.1.7")
//
////    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.10.2")
    implementation("androidx.core:core-ktx:1.16.0")
    implementation("androidx.core:core-splashscreen:1.0.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.9.2")
    implementation("androidx.activity:activity-compose:1.10.1")
    implementation(platform("androidx.compose:compose-bom:2025.07.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
////    implementation("androidx.compose.material3:material3")
//    implementation("androidx.compose.material3:material3-android:1.2.1")
//
//    implementation(libs.gradle) REMOVE ENTIRELY ****
    implementation("androidx.constraintlayout:constraintlayout:2.2.1")
//    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("com.google.android.datatransport:transport-runtime:4.0.0")
    implementation("com.google.android.gms:play-services-location:21.3.0")
    implementation("com.google.firebase:firebase-firestore-ktx:25.1.4")
    implementation("com.google.firebase:firebase-functions:22.0.0")
    implementation("com.google.firebase:firebase-firestore:26.0.0")
    implementation("com.google.firebase:firebase-auth-ktx:23.2.1")
    implementation(platform("org.jetbrains.kotlin:kotlin-ksp:1.4.0-rc-dev-experimental-20200828"))
    implementation(platform("org.jetbrains.kotlin:kotlin-bom:2.2.0"))
    implementation("com.squareup.picasso:picasso:2.71828")
    // RxAndroid
    implementation("io.reactivex.rxjava3:rxandroid:3.0.2")
    // RxJava
    implementation("io.reactivex.rxjava3:rxjava:3.1.11")
    // RxKotlin (optional, provides Kotlin-specific extensions)
    implementation("io.reactivex.rxjava3:rxkotlin:3.0.1")
    implementation("com.mikhaellopez:rxanimation:2.1.1")
////    implementation(libs.places)
    compile("com.reyurnible.rxanimation:rxanimations-kotlin:1.0.2")
    compile("com.loopeer.lib:shadow:0.0.4-beta3")

    // glide
    implementation("com.github.bumptech.glide:glide:4.16.0")
//
    // gson
    implementation("com.google.code.gson:gson:2.13.1")
//
    // volley
    implementation("com.android.volley:volley:1.2.1")
//
    // swipe to refresh
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
//
    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.9.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.9.2")
//
    // LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.9.2")
//
    // Feature module Support
    implementation("androidx.navigation:navigation-dynamic-features-fragment:2.9.3")
//    //implementation("androidx.test:runner:2.4.2")
    implementation("com.jakewharton.threetenabp:threetenabp:1.4.9")
//
    // search Algolia Kotlin API client
    implementation("com.algolia:algoliasearch-client-kotlin:2.0.0")
    implementation("io.ktor:ktor-client-okhttp:2.0.1")
    implementation("io.ktor:ktor-client-cio:2.0.1")
//    implementation("com.google.truth.extensions:truth-java8-extension:1.1.5")
    implementation("com.jakewharton.timber:timber:5.0.1")
    implementation("com.squareup.retrofit2:adapter-rxjava2:2.9.0")
//
    // stetho
    implementation("com.facebook.stetho:stetho:1.6.0")
    implementation("com.facebook.stetho:stetho-okhttp3:1.6.0")
    implementation("com.facebook.stetho:stetho-urlconnection:1.6.0")
//
    // Testing Navigation
    androidTestImplementation("androidx.navigation:navigation-testing:2.9.3")
    testImplementation("io.mockk:mockk:1.14.5")
    androidTestImplementation("io.mockk:mockk-android:1.14.5")
//
    // For JUnit 4 tests
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.robolectric:robolectric:4.15.1")
    testImplementation("androidx.test.ext:junit:1.3.0")
//
//    // For instrumented tests
    androidTestImplementation("androidx.test:rules:1.5.0")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2024.06.00"))
//    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
//
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
//
    // Jetpack Compose Integration
    implementation("androidx.navigation:navigation-compose:2.9.3")
//implementation("androidx.navigation:navigation-safe-args-gradle-plugin:2.9.3") <- remove has duplicate error
//
    // Java language implementation
    implementation("androidx.navigation:navigation-fragment-ktx:2.9.3")
    implementation("androidx.navigation:navigation-ui-ktx:2.9.3")
    // Moshi core library
    implementation("com.squareup.moshi:moshi:1.15.2")
    // Moshi Kotlin extensions for reflection-based adapters
    implementation("com.squareup.moshi:moshi-kotlin:1.15.2")
    // Kotlin reflection library (required by moshi-kotlin)
    implementation("org.jetbrains.kotlin:kotlin-reflect:2.2.0")
    // Moshi core library
    implementation("com.squareup.moshi:moshi-kotlin:1.15.2") // Check for the absolute latest stable version
//
    // Moshi Kotlin codegen for compile-time adapter generation
    ksp("com.squareup.moshi:moshi-kotlin-codegen:1.15.2")

    kotlin("androidx.room:room-compiler:2.5.0")
////    val kotlin_version = "2.2.0"
////    implementation("com.android.tools.build:gradle")
////    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
    implementation("com.google.gms:google-services:4.4.3")
    implementation("com.google.android.gms:play-services-auth:20.1.0")
//
    val room_version = "2.7.2"
    implementation("androidx.room:room-runtime:$room_version")
//    kapt("androidx.room:room-compiler:$room_version")
//    // If this project only uses Java source, use the Java annotationProcessor
//    // No additional plugins are necessary
//    implementation("androidx.room:room-compiler:$room_version")
//
//    // optional - Kotlin Extensions and Coroutines support for Room
    implementation("androidx.room:room-ktx:$room_version")
//
//    // optional - RxJava2 support for Room
//    implementation("androidx.room:room-rxjava2:$room_version")
//
//    // optional - RxJava3 support for Room
//    implementation("androidx.room:room-rxjava3:$room_version")
//
//    // optional - Guava support for Room, including Optional and ListenableFuture
//    implementation("androidx.room:room-guava:$room_version")
//
//    // optional - Test helpers
//    testImplementation("androidx.room:room-testing:$room_version")
//
//    // optional - Paging 3 Integration
    implementation("androidx.room:room-paging:$room_version")
//
//    // Retrofit Moshi converter
//    implementation("com.squareup.retrofit2:converter-moshi:2.11.0") // Check for the absolute latest stable version

    // Dagger core dependencies
    implementation("com.google.dagger:dagger:2.57")
    ksp("com.google.dagger:dagger-compiler:2.57") // Use ksp for Kotlin Symbol Processing

    // For Dagger Hilt (recommended for Android)
    implementation("com.google.dagger:hilt-android:2.57")
    ksp("com.google.dagger:hilt-compiler:2.57") // Use ksp for Kotlin Symbol Processing

////    kapt Dependencies.moshiKapt

////    implementation Dependencies.rxJavaAdapter
}