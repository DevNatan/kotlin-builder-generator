plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

group = "me.devnatan"
version = "0.1.0-SNAPSHOT"

kotlin {
    jvm()
    sourceSets {
        val jvmMain by getting {
            dependencies {
                implementation(libs.ksp)
            }
        }
    }
}