plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("plugin.serialization") version "1.9.0"
    id("com.google.gms.google-services") version "4.4.3"
}

android {
    namespace = "com.example.appkkweather"
    compileSdk = 34

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
    kotlinOptions {
        jvmTarget = "1.8"
    }
    externalNativeBuild {
        cmake {
            path = file("src/main/cpp/CMakeLists.txt")
            version = "3.22.1"
        }
    }
}

dependencies {

    implementation("androidx.compose.material:material:1.6.8")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.2")
    implementation("androidx.datastore:datastore-preferences:1.1.1")
    implementation("androidx.navigation:navigation-compose:2.7.7")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.core:core-splashscreen:1.0.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.2")
    implementation("androidx.activity:activity-compose:1.9.0")
    implementation(platform("androidx.compose:compose-bom:2024.06.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.material3:material3-android:1.2.1")
    implementation("androidx.compose.foundation:foundation-layout-android:1.6.8")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2024.06.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
    implementation("androidx.constraintlayout:constraintlayout:2.1.3")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("com.google.android.datatransport:transport-runtime:3.1.2")
    implementation("com.google.android.gms:play-services-location:19.0.1")
    implementation("com.google.firebase:firebase-firestore-ktx:24.1.0")
    implementation("com.google.firebase:firebase-functions:20.0.2")
    implementation("com.google.firebase:firebase-firestore:24.1.0")
    implementation("com.google.firebase:firebase-auth-ktx:21.0.3")
    implementation("com.google.android.gms:play-services-auth:20.1.0")


    //toasty
//    implementation ("com.github.GrenderG:Toasty:1.5.2")

    //glide
    implementation("com.github.bumptech.glide:glide:4.12.0")

    //gson
    implementation("com.google.code.gson:gson:2.8.9")

    // volley
    implementation("com.google.android.gms:play-services-location:19.0.1")
    implementation("com.android.volley:volley:1.2.1")

    //swipe to refresh
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")

    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")

    // LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.2.0")

    // Feature module Support
    implementation("androidx.navigation:navigation-dynamic-features-fragment:2.4.2")
    //implementation("androidx.test:runner:2.4.2")
    implementation("com.jakewharton.threetenabp:threetenabp:1.4.9")

    // search Algolia Kotlin API client
    implementation("com.algolia:algoliasearch-client-kotlin:3.4.0")

    implementation("io.ktor:ktor-client-okhttp:2.0.1")
    implementation("io.ktor:ktor-client-cio:2.0.1")
    implementation("com.google.truth.extensions:truth-java8-extension:1.1.5")

    // Testing Navigation
    androidTestImplementation("androidx.navigation:navigation-testing:2.4.2")
    testImplementation("io.mockk:mockk:1.14.2")
    androidTestImplementation("io.mockk:mockk-android:1.14.2")

    // For JUnit 4 tests
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.robolectric:robolectric:4.15.1")
    testImplementation("androidx.test.ext:junit:1.2.1")

    // For instrumented tests
    androidTestImplementation("androidx.test:rules:1.5.0")

    // Jetpack Compose Integration
    implementation("androidx.navigation:navigation-compose:2.4.2")

    // Java language implementation
    implementation("androidx.navigation:navigation-fragment-ktx:2.4.2")
    implementation("androidx.navigation:navigation-ui-ktx:2.4.2")
}