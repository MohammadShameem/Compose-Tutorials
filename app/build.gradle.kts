plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    compileSdk = libs.versions.compileSdk.get().toInt()
    defaultConfig {
        applicationId = "com.shameem.composefirstlesson"
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
        vectorDrawables.useSupportLibrary = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }


    buildTypes {
        getByName("debug") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro")
        }

        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro")
        }
    }

    testOptions {
        unitTests {
            isReturnDefaultValues = true
            isIncludeAndroidResources = true
        }
    }

    // Tests can be Robolectric or instrumented tests
    sourceSets {
        val sharedTestDir = "src/sharedTest/java"
        getByName("test") {
            java.srcDir(sharedTestDir)
        }
        getByName("androidTest") {
            java.srcDir(sharedTestDir)
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }
    packagingOptions {
        resources {
            excludes += setOf("/META-INF/AL2.0", "/META-INF/LGPL2.1")
        }
    }

    namespace = "com.shameem.composefirstlesson"
}

dependencies {
    implementation(libs.kotlin.stdlib)
    implementation(libs.kotlinx.coroutines.android)

    // TODO: Replace when all samples use the same Material3 & Compose version
    implementation("androidx.compose.animation:animation:1.3.0-beta01")
    implementation("androidx.compose.foundation:foundation-layout:1.3.0-beta01")
    implementation("androidx.compose.material:material-icons-extended:1.3.0-beta01")
    implementation("androidx.compose.material3:material3:1.0.0-beta01")
    implementation("androidx.compose.material3:material3-window-size-class:1.0.0-beta01")
    implementation("androidx.compose.runtime:runtime-livedata:1.3.0-beta01")
    implementation("androidx.compose.ui:ui-tooling-preview:1.3.0-beta01")
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.3.0-beta01")
    debugImplementation("androidx.compose.ui:ui-tooling:1.3.0-beta01")
//    implementation(libs.androidx.compose.animation)
//    implementation(libs.androidx.compose.foundation.layout)
//    implementation(libs.androidx.compose.material.iconsExtended)
//    implementation(libs.androidx.compose.material3)
//    implementation(libs.androidx.compose.materialWindow)
//    implementation(libs.androidx.compose.runtime.livedata)
//    implementation(libs.androidx.compose.ui.tooling.preview)
//    debugImplementation(libs.androidx.compose.ui.test.manifest)
//    debugImplementation(libs.androidx.compose.ui.tooling)

    implementation("com.google.accompanist:accompanist-swiperefresh:0.26.1-alpha")
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.26.1-alpha")
//    implementation(libs.accompanist.swiperefresh)
//    implementation(libs.accompanist.systemuicontroller)

    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.savedstate)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewModelCompose)

    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.window)

    implementation(libs.google.android.material)

    androidTestImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.core)
    androidTestImplementation(libs.androidx.test.runner)
    androidTestImplementation(libs.androidx.test.espresso.core)
    androidTestImplementation(libs.androidx.test.rules)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.kotlinx.coroutines.test)
    androidTestImplementation(libs.androidx.compose.ui.test)
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    // Robolectric dependencies
    // TODO: Replace when all samples use the same Material3 & Compose version
    implementation("androidx.compose.ui:ui-test-junit4:1.3.0-beta01")
//    testImplementation(libs.androidx.compose.ui.test.junit4)
    testImplementation(libs.robolectric)
}

tasks.withType<Test>().configureEach {
    systemProperties.put("robolectric.logging", "stdout")
}
