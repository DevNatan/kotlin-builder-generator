plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.ksp)
}

kotlin {
    jvm()
    linuxX64()

    sourceSets {
        val commonMain by getting
        val linuxX64Main by getting
        val macosX64Main by getting
    }
}

dependencies {
    add("kspCommonMainMetadata", projects.ksp)
    add("kspJvm", projects.ksp)
    add("kspMacosX64", projects.ksp)
    add("kspLinuxX64", projects.ksp)
}