plugins {
    id("com.android.application") version "8.10.0" apply false
    id("com.google.dagger.hilt.android") version "2.41" apply false
    id("org.jetbrains.kotlin.android") version "2.2.0" apply false
    kotlin("plugin.serialization") version "1.9.0"
    kotlin("jvm") version "2.2.0"
//    kotlin("kotlin-kapt") apply false
//    kotlin("kapt")
//    kotlin("kotlin-kapt") version "2.2.0"
    id("org.jetbrains.kotlin.kapt") version "2.2.0" apply false
    id("com.google.devtools.ksp") version "2.0.21-1.0.27" apply false

//    id("org.jetbrains.kotlin.kapt") version "2.2.0" apply false
//    id("kotlin-kapt")
    // Add this line for the google-services plugin classpath
    id("com.google.gms.google-services") version "4.4.3" apply false
    alias(libs.plugins.compose.compiler) apply false
//    alias(libs.plugins.kotlinKapt) apply false
//    kotlin("kapt")
}
