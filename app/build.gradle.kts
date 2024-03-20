plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.myapplication"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.myapplication"
        minSdk = 26
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
}

dependencies {
//    implementation("androidx.core:core-ktx:1.12.0")
//    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
//    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("com.google.firebase:firebase-bom:32.3.1"))
//    implementation("com.google.firebase:firebase-analytics-ktx:21.5.0")
//    implementation(platform("androidx.compose:compose-bom:2023.09.02"))
//    implementation("androidx.compose.ui:ui:1.5.4")
//    implementation("androidx.compose.ui:ui-graphics:1.5.4")
//    implementation("androidx.compose.ui:ui-tooling-preview:1.5.4")
//    implementation("androidx.compose.material3:material3:1.1.2")
    implementation("com.google.firebase:firebase-auth")
//    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
//    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
//    implementation("com.android.support:multidex:1.0.3")
//    implementation("com.squareup.picasso:picasso:2.71828")
    implementation("com.firebaseui:firebase-ui-firestore:8.0.2")
//    implementation("com.firebaseui:firebase-ui-database:8.0.2")
//    implementation("com.google.firebase:firebase-database:20.3.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation ("com.hbb20:ccp:2.7.3")
    implementation("com.google.firebase:firebase-firestore:24.10.0")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation("com.google.firebase:firebase-storage:20.3.0")
    implementation("com.google.firebase:firebase-messaging:23.4.0")
    //implementation("com.google.firebase:firebase-firestore:24.10.0")
    //implementation("com.google.firebase:firebase-storage:20.3.0")
    testImplementation("junit:junit:4.13.2")
    implementation("com.github.bumptech.glide:glide:4.16.0")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    implementation("com.github.dhaval2404:imagepicker:2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    //androidTestImplementation(platform("androidx.compose:compose-bom:2023.09.02"))
    //androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.5.4")
    //debugImplementation("androidx.compose.ui:ui-tooling:1.5.4")
    //debugImplementation("androidx.compose.ui:ui-test-manifest:1.5.4")
}