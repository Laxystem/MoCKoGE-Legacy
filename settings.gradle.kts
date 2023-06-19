rootProject.name = "mockoge"
include("math:codegen", "core", "util")

pluginManagement {
    val kotlin: String by settings
    val ksp: String by settings

    plugins {
        id("com.google.devtools.ksp") version "$kotlin-$ksp" apply false
        kotlin("multiplatform") version kotlin apply false
        kotlin("jvm") version kotlin apply false
    }

    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}
