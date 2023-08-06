pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}

include("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "kotlin-builder-generator"
include("lib", "ksp")