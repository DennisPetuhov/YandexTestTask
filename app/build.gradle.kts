plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.serialization)
    alias(libs.plugins.ktorfit)

}
ktorfit {}

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
vectorDrawables {useSupportLibrary = true}
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

// Ktorfit
implementation(libs.ktorfit.lib)
implementation(libs.ktor.client.serialization)
implementation(libs.ktor.client.content.negotiation)
implementation(libs.ktor.serialization.kotlinx.json)
implementation(libs.ktorfit.converters.response)
implementation(libs.ktorfit.converters.call)
implementation(libs.ktorfit.converters.flow)
}