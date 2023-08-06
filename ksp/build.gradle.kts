plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.ksp)
}

group = "me.devnatan.kbg"
version = "0.1.0-SNAPSHOT"

kotlin {
    jvm()
}

dependencies {
    commonMainImplementation(project(":lib"))
    commonMainImplementation(libs.ksp)
}