plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    //=>topLevel
    id("com.google.dagger.hilt.android") version "2.51.1" apply false


}