buildscript {
    dependencies {
        classpath ("com.google.gms:google-services:4.4.4")
    }
}

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.compose) apply false
    id("com.google.firebase.crashlytics") version "3.0.6" apply false
    id("org.lsposed.lsparanoid") version "0.6.0"
}