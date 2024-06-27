plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.serialization)
    alias(libs.plugins.ktorfit)

}
ktorfit {}
ksp {
    arg("ktorfit", "true")
}


android {
    namespace = "com.example.yandextesttask"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.yandextesttask"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables { useSupportLibrary = true }
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
//tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
//kotlinOptions {
//jvmTarget = "1.8"
//}
//}


dependencies {

//project(":core:ui")

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.legacy.support.v4)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.fragment.ktx)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

//    implementation(platform(libs.koin.bom))
//    implementation(libs.koin.core)
    implementation(libs.koin.android)
//    implementation(libs.koin.androidx.viewmodel)

// Ktorfit
    implementation(libs.ktorfit.lib)
    implementation(libs.ktor.client.serialization)
    implementation(libs.ktor.client.content.negotiation)
    implementation(libs.ktor.serialization.kotlinx.json)
    implementation(libs.ktorfit.converters.response)
    implementation(libs.ktorfit.converters.call)
    implementation(libs.ktorfit.converters.flow)
    implementation( libs.ktor.client.android)
    implementation(libs.ktor.ktor.client.logging)
    implementation(libs.ktor.client.cio)

    implementation(libs.kspApi)
    //data store
    implementation(libs.androidx.datastore.preferences)
    //retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

// Retrofit with Scalar Converter
    implementation("com.squareup.retrofit2:converter-scalars:2.9.0")
    // Retrofit with Moshi Converter
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")
    // Moshi
    implementation("com.squareup.moshi:moshi-kotlin:1.13.0")

//    implementation("com.rickclephas.kmm:kmm-viewmodel-core:1.0.0-ALPHA-3")
implementation( "androidx.lifecycle:lifecycle-viewmodel:2.5.1")
}