   // Navigation
    val nav_version = "2.8.9"
    implementation("androidx.navigation:navigation-compose:$nav_version")
    
    // Dagger - Hilt
    implementation("com.google.dagger:hilt-android:2.48")
    kapt("com.google.dagger:hilt-compiler:2.44")
    kapt("androidx.hilt:hilt-compiler:1.1.0")
    implementation("androidx.hilt:hilt-navigation-compose:1.1.0")
       // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:4.11.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.10.0")

    // Coil
    implementation("io.coil-kt:coil-compose:2.4.0")
    
    val room_version = "2.6.1"
    implementation("androidx.room:room-runtime:$room_version")
    ksp("androidx.room:room-compiler:$room_version")
    annotationProcessor("androidx.room:room-compiler:$room_version")
    implementation("androidx.room:room-ktx:$room_version")
    implementation("androidx.room:room-guava:$room_version")
    testImplementation("androidx.room:room-testing:$room_version")
    implementation("androidx.room:room-paging:$room_version")


kapt {
    correctErrorTypes = true
}

//=>GradleBuild:plugins
id("com.google.devtools.ksp")
id("kotlin-kapt")
id("com.google.dagger.hilt.android")

//=>topLevel
id("com.google.dagger.hilt.android") version "2.51.1" apply false
id("com.google.devtools.ksp") version "2.0.21-1.0.27" apply false




